package pl.matiz22.cocktailapp.android.core.navigation.route

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

    @Serializable
    data object Drinks : AppRoutes() {
        @Serializable
        data object DrinkHome : AppRoutes()

        @Serializable
        data class DrinkDetails(val drinkId: String) : AppRoutes()
    }
}
