package pl.matiz22.cocktailapp.android.core.presentation.navigation.route

import kotlinx.serialization.Serializable

@Serializable
sealed class AppRoutes {
    @Serializable
    data object Home : AppRoutes() {
        @Serializable
        data object HomeScreen : AppRoutes()
    }

    @Serializable
    data object Search : AppRoutes() {
        @Serializable
        data object SearchByNameScreen : AppRoutes()
    }

    @Serializable
    data object Favourites : AppRoutes() {
        @Serializable
        data object FavouritesScreen : AppRoutes()
    }
}
