package pl.matiz22.cocktailapp.android.home.presentation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pl.matiz22.cocktailapp.android.core.presentation.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.home.presentation.screens.HomeScreen

fun NavGraphBuilder.homeGraph(
    navController: NavController
) {
    navigation<AppRoutes.Home>(startDestination = AppRoutes.Home.HomeScreen) {
        composable<AppRoutes.Home.HomeScreen> {
            HomeScreen()
        }
    }
}
