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

class HomeScreenViewModel(
    private val drinksLocalRepository: DrinksLocalRepository,
) : ViewModel() {
    private val _recentDrinks = MutableStateFlow<DataState<Drinks>>(DataState.Loading)
    val recentDrinks = _recentDrinks.asStateFlow()

    init {
        updateRecentDrinks()
    }

    fun updateRecentDrinks() {
        viewModelScope.launch {
            val databaseResult = drinksLocalRepository.getRecentDrinks()

            if (databaseResult.error != null) {
                _recentDrinks.emit(DataState.Error(databaseResult.error!!.errorMessage))
            } else if (databaseResult.data != null) {
                _recentDrinks.emit(DataState.Success(databaseResult.data!!))
            }
        }
    }
}
