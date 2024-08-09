package pl.matiz22.cocktailapp.android.drinks.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.states.DataState
import pl.matiz22.cocktailapp.cocktails.domain.model.Drink
import pl.matiz22.cocktailapp.cocktails.domain.repository.local.DrinksLocalRepository
import pl.matiz22.cocktailapp.cocktails.domain.repository.remote.DrinksRepository
import pl.matiz22.cocktailapp.root.data.repository.errorMessage
import pl.matiz22.cocktailapp.root.domain.model.DataError
import pl.matiz22.cocktailapp.root.domain.model.Result

class DrinkDetailsViewModel(
    private val drinkId: String,
    private val drinksRepository: DrinksRepository,
    private val drinksLocalRepository: DrinksLocalRepository
) : ViewModel() {

    private val _drink = MutableStateFlow<DataState<Drink>>(DataState.Loading)
    val drink = _drink.asStateFlow()

    init {
        fetchDrink()
    }

    private fun fetchDrink() {
        viewModelScope.launch {
            _drink.emit(DataState.Loading)
            val localResult = drinksLocalRepository.getDrink(drinkId)
            when (val networkResult = drinksRepository.getDrinkById(drinkId)) {
                is Result.Error -> {
                    when (localResult) {
                        is Result.Error -> {
                            _drink.emit(DataState.Error(networkResult.error.errorMessage))
                        }

                        is Result.Success -> {
                            _drink.emit(DataState.Success(localResult.data))
                        }
                    }
                }

                is Result.Success -> {
                    val currentDrink = networkResult.data.copy(
                        liked = (localResult as? Result.Success<Drink, DataError.Local>)
                            ?.data?.liked ?: false
                    )
                    _drink.emit(
                        DataState.Success(currentDrink)
                    )
                    drinksLocalRepository.saveDrink(currentDrink)
                }
            }
        }
    }
}
