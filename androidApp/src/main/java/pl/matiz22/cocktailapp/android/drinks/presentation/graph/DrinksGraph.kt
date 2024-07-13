package pl.matiz22.cocktailapp.android.drinks.presentation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import pl.matiz22.cocktailapp.android.core.presentation.navigation.route.AppRoutes

fun NavGraphBuilder.drinksGraph(navController: NavController) {
    navigation<AppRoutes.Drinks>(startDestination = AppRoutes.Drinks.DrinkHome) {
        composable<AppRoutes.Drinks.DrinkHome> { /* Drink Home to stop Companion serializer error */ }
        composable<AppRoutes.Drinks.DrinkDetails> { navBackStackEntry ->
            val args = navBackStackEntry.toRoute<AppRoutes.Drinks.DrinkDetails>()
        }
    }
}
