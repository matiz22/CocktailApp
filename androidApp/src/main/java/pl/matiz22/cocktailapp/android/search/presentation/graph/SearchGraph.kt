package pl.matiz22.cocktailapp.android.search.presentation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pl.matiz22.cocktailapp.android.core.presentation.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.search.presentation.screens.SearchByNameScreen

fun NavGraphBuilder.searchGraph(
    navController: NavController
) {
    navigation<AppRoutes.Search>(startDestination = AppRoutes.Search.SearchByNameScreen) {
        composable<AppRoutes.Search.SearchByNameScreen> {
            SearchByNameScreen()
        }
    }
}
