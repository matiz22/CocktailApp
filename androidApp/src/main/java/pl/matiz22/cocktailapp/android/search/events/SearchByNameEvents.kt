package pl.matiz22.cocktailapp.android.search.events

sealed class SearchByNameEvents {
    data class UpdateQuery(val query: String) : SearchByNameEvents()
    data object ClearQuery : SearchByNameEvents()
}
