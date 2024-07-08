package pl.matiz22.cocktailapp.core.data.repository

import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.core.domain.model.NavHeaders
import pl.matiz22.cocktailapp.core.domain.repository.NavHeadersRepository

/**
 * Repository provides headers for given route.
 * Destination from navigation doesn't provide type, so it has to be based on route string,
 * which is package path
 */
class NavHeadersRepositoryImpl : NavHeadersRepository {
    override fun provideNavHeaders(route: String): NavHeaders? {
        val searchText = "AppRoutes."
        val startIndex = route.indexOf(searchText)
        if (startIndex != -1) {
            val extractedTextStart = startIndex + searchText.length
            val extractedText = route.substring(extractedTextStart)
            return when (extractedText) {
                "Home.HomeScreen" -> {
                    NavHeaders(
                        title = SharedRes.string.nav_home,
                        description = SharedRes.string.nav_home_home_screen_description,
                        isNavigationBack = false
                    )
                }

                "Search.SearchByNameScreen" -> {
                    NavHeaders(
                        title = SharedRes.string.nav_search,
                        description = SharedRes.string.nav_search_search_by_name_description,
                        isNavigationBack = false
                    )
                }

                "Favourites.FavouritesScreen" -> {
                    NavHeaders(
                        title = SharedRes.string.nav_favourite,
                        description = SharedRes.string.nav_favourite_favourite_screen_description,
                        isNavigationBack = false
                    )
                }

                else -> {
                    null
                }
            }
        }
        return null
    }
}
