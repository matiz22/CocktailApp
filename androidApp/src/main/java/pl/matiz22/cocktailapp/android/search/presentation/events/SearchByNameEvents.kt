package pl.matiz22.cocktailapp.android.search.presentation.events

import pl.matiz22.cocktailapp.cocktails.domain.model.Drink

sealed class SearchByNameEvents {
    data class UpdateQuery(val query: String) : SearchByNameEvents()
    data object ClearQuery : SearchByNameEvents()
}
