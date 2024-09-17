package pl.matiz22.cocktailapp.android.drinks.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pl.matiz22.cocktailapp.android.core.states.DataState
import pl.matiz22.cocktailapp.android.drinks.events.DrinkDetailsEvent
import pl.matiz22.cocktails.domain.model.Drink
import pl.matiz22.cocktails.domain.repository.local.DrinksLocalRepository
import pl.matiz22.cocktails.domain.repository.remote.DrinksRepository
import pl.matiz22.core.data.repository.errorMessage

class DrinkDetailsViewModel(
    private val drinkId: String,
    private val drinksRepository: DrinksRepository,
    private val drinksLocalRepository: DrinksLocalRepository,
) : ViewModel() {
    private val _drink = MutableStateFlow<DataState<Drink>>(DataState.Loading)
    val drink = _drink.asStateFlow()

    init {
        fetchDrink()
    }

    fun onEvent(drinkDetailsEvent: DrinkDetailsEvent) {
        when (drinkDetailsEvent) {
            DrinkDetailsEvent.FavouriteClicked -> {
                changeFavouriteField()
            }
        }
    }

    private fun changeFavouriteField() {
        val currentDrink = (_drink.value as? DataState.Success<Drink>) ?: return
        val newFavouriteField = !currentDrink.data.liked
        val updatedDrink = currentDrink.data.copy(liked = newFavouriteField)
        viewModelScope.launch {
            drinksLocalRepository.saveDrink(updatedDrink)
        }
        _drink.value = DataState.Success(updatedDrink)
    }

    private fun fetchDrink() {
        viewModelScope.launch {
            _drink.emit(DataState.Loading)
            val localResult = drinksLocalRepository.getDrink(drinkId)
            val networkResult = drinksRepository.getDrinkById(drinkId)
            if (networkResult.error != null) {
                if (localResult.error != null) {
                    _drink.emit(DataState.Error(networkResult.error!!.errorMessage))
                } else if (localResult.data != null) {
                    _drink.emit(DataState.Success(localResult.data!!))
                }
            } else if (networkResult.data != null) {
                val currentDrink = networkResult.data!!.copy(
                    liked = localResult.data?.liked ?: false,
                )
                _drink.emit(DataState.Success(currentDrink))
                drinksLocalRepository.saveDrink(currentDrink)
            }
        }
    }
}
