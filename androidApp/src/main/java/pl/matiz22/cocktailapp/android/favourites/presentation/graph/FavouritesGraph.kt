package pl.matiz22.cocktailapp.android.favourites.presentation.graph

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.koin.androidx.compose.koinViewModel
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.composables.appbar.AppBar
import pl.matiz22.cocktailapp.android.core.presentation.composables.appscaffold.AppScaffold
import pl.matiz22.cocktailapp.android.core.presentation.composables.bottombar.BottomBar
import pl.matiz22.cocktailapp.android.core.presentation.composables.loading.CircularLoading
import pl.matiz22.cocktailapp.android.core.presentation.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.core.presentation.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.core.presentation.navigation.util.navItems
import pl.matiz22.cocktailapp.android.core.presentation.states.DataState
import pl.matiz22.cocktailapp.android.favourites.presentation.screens.FavouritesScreen
import pl.matiz22.cocktailapp.android.favourites.presentation.viewmodels.FavouritesScreenViewModel
import pl.matiz22.cocktailapp.cocktails.domain.model.Drink

fun NavGraphBuilder.favouritesGraph(
    navController: NavController
) {
    navigation<AppRoutes.Favourites>(startDestination = AppRoutes.Favourites.FavouritesScreen) {
        composable<AppRoutes.Favourites.FavouritesScreen> {
            val favouritesScreenViewModel = koinViewModel<FavouritesScreenViewModel>()
            val favDrinks by favouritesScreenViewModel.favDrinks.collectAsStateWithLifecycle()
            AppScaffold(
                topAppbar = {
                    AppBar(
                        leftSideContent = {
                            TitleAndDescription(
                                title = SharedRes.string.nav_favourite,
                                description = SharedRes.string.nav_favourite_favourite_screen_description
                            )
                        }
                    )
                },
                bottomAppbar = {
                    BottomBar(
                        navItems = navItems(navController = navController)
                    )
                }
            ) {
                when (val result = favDrinks) {
                    is DataState.Error -> TODO()
                    DataState.Loading -> {
                        CircularLoading()
                    }

                    is DataState.Success -> {
                        FavouritesScreen(
                            favDrinks = result.data,
                            navToDetails = { drink: Drink ->
                                navController.navigate(AppRoutes.Drinks.DrinkDetails(drink.id))
                            }
                        )
                    }
                }
            }
        }
    }
}
