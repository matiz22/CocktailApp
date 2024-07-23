package pl.matiz22.cocktailapp.android.drinks.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.states.DataState
import pl.matiz22.cocktailapp.cocktails.domain.model.Drink
import pl.matiz22.cocktailapp.cocktails.domain.repository.remote.DrinksRepository
import pl.matiz22.cocktailapp.root.data.repository.errorMessage
import pl.matiz22.cocktailapp.root.domain.model.Result

class DrinkDetailsViewModel(
    private val drinkId: String,
    private val drinksRepository: DrinksRepository
) : ViewModel() {

    private val _drink = MutableStateFlow<DataState<Drink>>(DataState.Loading)
    val drink = _drink.asStateFlow()

    init {
        fetchDrink()
    }

    private fun fetchDrink() {
        viewModelScope.launch {
            when (val detailsResult = drinksRepository.getDrinkById(drinkId)) {
                is Result.Error -> {
                    _drink.emit(DataState.Error(detailsResult.error.errorMessage))
                }

                is Result.Success -> {
                    if (detailsResult.data != null) {
                        _drink.emit(DataState.Success(detailsResult.data!!))
                    } else {
                        _drink.emit(DataState.Error(SharedRes.string.error_not_found))
                    }
                }
            }
        }
    }
}
