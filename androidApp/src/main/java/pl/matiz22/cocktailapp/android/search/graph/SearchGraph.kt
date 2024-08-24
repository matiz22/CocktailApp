package pl.matiz22.cocktailapp.android.search.graph

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.koin.androidx.compose.koinViewModel
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.composables.appbar.AppBar
import pl.matiz22.cocktailapp.android.core.composables.appscaffold.AppScaffold
import pl.matiz22.cocktailapp.android.core.composables.bottombar.BottomBar
import pl.matiz22.cocktailapp.android.core.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.core.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.core.navigation.util.navItems
import pl.matiz22.cocktailapp.android.search.screens.SearchByNameScreen
import pl.matiz22.cocktailapp.android.search.viewmodels.SearchByNameViewModel
import pl.matiz22.cocktails.domain.model.Drink

fun NavGraphBuilder.searchGraph(navController: NavController) {
    navigation<AppRoutes.Search>(startDestination = AppRoutes.Search.SearchByNameScreen) {
        composable<AppRoutes.Search.SearchByNameScreen> { navBackstackEntry ->
            val searchByNameViewModel =
                koinViewModel<SearchByNameViewModel>(viewModelStoreOwner = navBackstackEntry)
            val query by searchByNameViewModel.query.collectAsStateWithLifecycle()
            val drinks by searchByNameViewModel.drinksResult.collectAsStateWithLifecycle()
            AppScaffold(
                topAppbar = {
                    AppBar(
                        leftSideContent = {
                            TitleAndDescription(
                                title = SharedRes.string.nav_search,
                                description = SharedRes.string.nav_search_search_by_name_description,
                            )
                        },
                    )
                },
                bottomAppbar = {
                    BottomBar(
                        navItems = navItems(navController = navController),
                    )
                },
            ) {
                SearchByNameScreen(
                    query = query,
                    drinks = drinks,
                    onEvent = searchByNameViewModel::onEvent,
                    pickResult = { drink: Drink ->
                        navController.navigate(AppRoutes.Drinks.DrinkDetails(drinkId = drink.id))
                    },
                )
            }
        }
    }
}
