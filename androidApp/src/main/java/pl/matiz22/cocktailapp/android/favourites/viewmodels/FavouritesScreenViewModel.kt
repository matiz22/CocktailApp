package pl.matiz22.cocktailapp.android.favourites.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pl.matiz22.cocktailapp.android.core.states.DataState
import pl.matiz22.cocktails.domain.model.Drinks
import pl.matiz22.cocktails.domain.repository.local.DrinksLocalRepository
import pl.matiz22.core.data.repository.errorMessage

class FavouritesScreenViewModel(
    private val drinksLocalRepository: DrinksLocalRepository,
) : ViewModel() {
    private val _favDrinks = MutableStateFlow<DataState<Drinks>>(DataState.Loading)
    val favDrinks = _favDrinks.asStateFlow()

    init {
        updateFavouritesDrinks()
    }

    fun updateFavouritesDrinks() {
        viewModelScope.launch {
            val databaseResult = drinksLocalRepository.getFavDrinks()
            if (databaseResult.error != null) {
                _favDrinks.emit(DataState.Error(databaseResult.error!!.errorMessage))
            } else if (databaseResult.data != null) {
                _favDrinks.emit(DataState.Success(databaseResult.data!!))
            }
        }
    }
}
