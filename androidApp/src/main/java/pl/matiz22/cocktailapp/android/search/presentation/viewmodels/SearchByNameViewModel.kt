package pl.matiz22.cocktailapp.android.search.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn
import pl.matiz22.cocktailapp.android.search.presentation.events.SearchByNameEvents
import pl.matiz22.cocktails.domain.model.Drinks
import pl.matiz22.cocktails.domain.repository.remote.DrinksRepository
import pl.matiz22.core.domain.model.Result

class SearchByNameViewModel(
    private val drinksRepository: DrinksRepository
) : ViewModel() {

    private var _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    private val _drinksResult = MutableStateFlow(Drinks(emptyList()))

    @OptIn(FlowPreview::class)
    val drinksResult = _query
        .debounce(500L)
        .combine(_drinksResult) { text, _ ->
            if (text.isEmpty() || text.isBlank()) {
                return@combine _drinksResult.value
            }
            return@combine when (val result = drinksRepository.getDrinksByName(text)) {
                is Result.Error -> {
                    _drinksResult.value
                }

                is Result.Success -> {
                    _drinksResult.emit(result.data)
                    result.data
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(500),
            initialValue = _drinksResult.value
        )

    fun onEvent(event: SearchByNameEvents) {
        when (event) {
            SearchByNameEvents.ClearQuery -> {
                _query.value = ""
            }

            is SearchByNameEvents.UpdateQuery -> {
                _query.value = event.query
            }
        }
    }
}
