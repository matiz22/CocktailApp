package pl.matiz22.cocktailapp.android.home.presentation.graph

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import io.github.skeptick.libres.compose.painterResource
import org.koin.androidx.compose.koinViewModel
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.R
import pl.matiz22.cocktailapp.android.core.composables.appbar.AppBar
import pl.matiz22.cocktailapp.android.core.composables.appscaffold.AppScaffold
import pl.matiz22.cocktailapp.android.core.composables.bottombar.BottomBar
import pl.matiz22.cocktailapp.android.core.composables.loading.CircularLoading
import pl.matiz22.cocktailapp.android.core.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.core.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.core.navigation.util.navItems
import pl.matiz22.cocktailapp.android.core.states.DataState
import pl.matiz22.cocktailapp.android.home.presentation.screens.HomeScreen
import pl.matiz22.cocktailapp.android.home.viewmodels.HomeScreenViewModel

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation<AppRoutes.Home>(startDestination = AppRoutes.Home.HomeScreen) {
        composable<AppRoutes.Home.HomeScreen> {
            val homeViewModel = koinViewModel<HomeScreenViewModel>()
            val recentDrinks by homeViewModel.recentDrinks.collectAsStateWithLifecycle()
            AppScaffold(
                topAppbar = {
                    AppBar(
                        leftSideContent = {
                            TitleAndDescription(
                                title = SharedRes.string.nav_home,
                                description = SharedRes.string.nav_home_home_screen_description,
                            )
                        },
                        rightSideContent = {
                            IconButton(onClick = {
                                navController.navigate(route = AppRoutes.Settings)
                            }) {
                                Icon(
                                    painter = painterResource(R.drawable.settings),
                                    contentDescription = null,
                                )
                            }
                        },
                    )
                },
                bottomAppbar = {
                    BottomBar(
                        navItems = navItems(navController = navController),
                    )
                },
            ) {
                when (val drinks = recentDrinks) {
                    is DataState.Error -> TODO()
                    DataState.Loading -> {
                        CircularLoading()
                    }

                    is DataState.Success -> {
                        HomeScreen(
                            recentDrinks = drinks.data,
                            navigateToDetails = { drink ->
                                navController.navigate(AppRoutes.Drinks.DrinkDetails(drink.id))
                            },
                        )
                    }
                }
            }
        }
    }
}
