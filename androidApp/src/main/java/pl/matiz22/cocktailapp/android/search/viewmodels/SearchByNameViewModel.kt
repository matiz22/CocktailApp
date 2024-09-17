package pl.matiz22.cocktailapp.android.search.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn
import pl.matiz22.cocktailapp.android.search.events.SearchByNameEvents
import pl.matiz22.cocktails.domain.model.Drinks
import pl.matiz22.cocktails.domain.repository.remote.DrinksRepository

class SearchByNameViewModel(
    private val drinksRepository: DrinksRepository,
) : ViewModel() {
    private var _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    private val _drinksResult = MutableStateFlow(Drinks(emptyList()))

    @OptIn(FlowPreview::class)
    val drinksResult =
        _query
            .debounce(500L)
            .combine(_drinksResult) { text, _ ->
                if (text.isEmpty() || text.isBlank()) {
                    return@combine _drinksResult.value
                }
                val result = drinksRepository.getDrinksByName(text)
                if (result.data != null) {
                    _drinksResult.emit(result.data!!)
                    return@combine result.data!!
                } else {
                    return@combine _drinksResult.value
                }
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(500),
                initialValue = _drinksResult.value,
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
