package pl.matiz22.cocktailapp.android.home.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import pl.matiz22.cocktailapp.android.core.states.DataState
import pl.matiz22.cocktails.domain.model.Drinks
import pl.matiz22.cocktails.domain.repository.local.DrinksLocalRepository
import pl.matiz22.core.data.repository.errorMessage
import pl.matiz22.core.domain.model.Result

class HomeScreenViewModel(
    private val drinksLocalRepository: DrinksLocalRepository
) : ViewModel() {

    private val _recentDrinks = MutableStateFlow<DataState<Drinks>>(DataState.Loading)
    val recentDrinks = _recentDrinks.asStateFlow()

    init {
        updateRecentDrinks()
    }

    fun updateRecentDrinks() {
        viewModelScope.launch {
            when (val databaseResult = drinksLocalRepository.getRecentDrinks()) {
                is Result.Error -> {
                    _recentDrinks.emit(DataState.Error(databaseResult.error.errorMessage))
                }
                is Result.Success -> {
                    _recentDrinks.emit(DataState.Success(databaseResult.data))
                }
            }
        }
    }
}