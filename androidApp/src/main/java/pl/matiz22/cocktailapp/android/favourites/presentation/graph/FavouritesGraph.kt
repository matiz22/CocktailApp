package pl.matiz22.cocktailapp.android.favourites.presentation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.composables.appbar.AppBar
import pl.matiz22.cocktailapp.android.core.presentation.composables.appscaffold.AppScaffold
import pl.matiz22.cocktailapp.android.core.presentation.composables.bottombar.BottomBar
import pl.matiz22.cocktailapp.android.core.presentation.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.core.presentation.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.core.presentation.navigation.util.navItems
import pl.matiz22.cocktailapp.android.favourites.presentation.screens.FavouritesScreen

fun NavGraphBuilder.favouritesGraph(
    navController: NavController
) {
    navigation<AppRoutes.Favourites>(startDestination = AppRoutes.Favourites.FavouritesScreen) {
        composable<AppRoutes.Favourites.FavouritesScreen> {
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
                FavouritesScreen()
            }
        }
    }
}
