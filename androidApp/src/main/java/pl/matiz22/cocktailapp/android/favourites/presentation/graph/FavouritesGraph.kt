package pl.matiz22.cocktailapp.android.favourites.presentation.graph

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
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
import pl.matiz22.cocktailapp.android.core.presentation.screens.ErrorScreen
import pl.matiz22.cocktailapp.android.core.presentation.states.DataState
import pl.matiz22.cocktailapp.android.favourites.presentation.screens.FavouritesScreen
import pl.matiz22.cocktailapp.android.favourites.presentation.viewmodels.FavouritesScreenViewModel
import pl.matiz22.cocktails.domain.model.Drink

fun NavGraphBuilder.favouritesGraph(
    navController: NavController
) {
    navigation<AppRoutes.Favourites>(startDestination = AppRoutes.Favourites.FavouritesScreen) {
        composable<AppRoutes.Favourites.FavouritesScreen> { navBackStackEntry ->
            val favouritesScreenViewModel =
                koinViewModel<FavouritesScreenViewModel>(viewModelStoreOwner = navBackStackEntry)
            val favDrinks by favouritesScreenViewModel.favDrinks.collectAsStateWithLifecycle()
            val lifecycle = navBackStackEntry.lifecycle

            DisposableEffect(key1 = lifecycle.currentState) {
                val observer = LifecycleEventObserver { _: LifecycleOwner, event: Lifecycle.Event ->
                    when (event) {
                        Lifecycle.Event.ON_RESUME -> favouritesScreenViewModel.updateFavouritesDrinks()
                        else -> {}
                    }
                }
                lifecycle.addObserver(observer)
                onDispose {
                    lifecycle.removeObserver(observer)
                }
            }

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
                    is DataState.Error -> {
                        ErrorScreen(errorMessage = result.message)
                    }

                    DataState.Loading -> {
                        CircularLoading(modifier = Modifier.size(200.dp))
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
