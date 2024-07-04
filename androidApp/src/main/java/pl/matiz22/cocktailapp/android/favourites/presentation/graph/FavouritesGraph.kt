package pl.matiz22.cocktailapp.android.favourites.presentation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pl.matiz22.cocktailapp.android.core.presentation.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.favourites.presentation.screens.FavouritesScreen

fun NavGraphBuilder.favouritesGraph(
    navController: NavController
) {
    navigation<AppRoutes.Favourites>(startDestination = AppRoutes.Favourites.FavouritesScreen) {
        composable<AppRoutes.Favourites.FavouritesScreen> {
            FavouritesScreen()
        }
    }
}
