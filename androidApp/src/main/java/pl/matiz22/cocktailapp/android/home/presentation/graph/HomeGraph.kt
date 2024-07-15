package pl.matiz22.cocktailapp.android.home.presentation.graph

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
import pl.matiz22.cocktailapp.android.home.presentation.screens.HomeScreen


fun NavGraphBuilder.homeGraph(
    navController: NavController
) {
    navigation<AppRoutes.Home>(startDestination = AppRoutes.Home.HomeScreen) {
        composable<AppRoutes.Home.HomeScreen> {
            AppScaffold(
                topAppbar = {
                    AppBar(
                        leftSideContent = {
                            TitleAndDescription(
                                title = SharedRes.string.nav_home,
                                description = SharedRes.string.nav_home_home_screen_description
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
                HomeScreen()
            }
        }
    }
}
