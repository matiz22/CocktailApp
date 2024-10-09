package pl.matiz22.cocktailapp.android.drinks.graph

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import androidx.navigation.toRoute
import io.github.skeptick.libres.compose.painterResource
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.composables.appbar.AppBar
import pl.matiz22.cocktailapp.android.core.composables.appscaffold.AppScaffold
import pl.matiz22.cocktailapp.android.core.composables.iconbutton.AppIconButton
import pl.matiz22.cocktailapp.android.core.composables.loading.CircularLoading
import pl.matiz22.cocktailapp.android.core.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.core.screens.ErrorScreen
import pl.matiz22.cocktailapp.android.core.states.DataState
import pl.matiz22.cocktailapp.android.drinks.screens.DrinkDetailsScreen
import pl.matiz22.cocktailapp.android.drinks.viewmodels.DrinkDetailsViewModel
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

fun NavGraphBuilder.drinksGraph(navController: NavController) {
    navigation<AppRoutes.Drinks>(startDestination = AppRoutes.Drinks.DrinkHome) {
        composable<AppRoutes.Drinks.DrinkHome> { /* Drink Home to stop Companion serializer error */ }
        composable<AppRoutes.Drinks.DrinkDetails>(
            deepLinks = listOf(
                navDeepLink<AppRoutes.Drinks.DrinkDetails>(basePath = "cocktail_app://cocktails/drink"),
            ),
        ) { navBackStackEntry ->
            val args = navBackStackEntry.toRoute<AppRoutes.Drinks.DrinkDetails>()
            val lazyListState = rememberLazyListState()
            val scrollOffset by remember { derivedStateOf { lazyListState.firstVisibleItemScrollOffset } }
            val visibleItem by remember { derivedStateOf { lazyListState.firstVisibleItemIndex == 0 } }
            val appBarColor by animateColorAsState(
                targetValue =
                if (visibleItem) {
                    CocktailsAppTheme.colors.background.copy(
                        alpha = (scrollOffset / 300f).coerceIn(0f, 1f),
                    )
                } else {
                    CocktailsAppTheme.colors.background
                },
                label = "imageAnimation",
            )
            val drinksDetailsViewModel =
                koinViewModel<DrinkDetailsViewModel> { parametersOf(args.drinkId) }
            val drink by drinksDetailsViewModel.drink.collectAsStateWithLifecycle()
            AppScaffold(
                disableTopPadding = true,
                topAppbar = {
                    AppBar(
                        color = appBarColor,
                        leftSideContent = {
                            AppIconButton(
                                painter = SharedRes.image.arrow_left.painterResource(),
                                tint =
                                if (appBarColor.alpha > 0.8f) {
                                    CocktailsAppTheme.colors.onBackground
                                } else {
                                    CocktailsAppTheme.colors.monochromatic10
                                },
                                onClick = {
                                    val previousBackStack =
                                        navController.previousBackStackEntry?.toRoute<AppRoutes.Drinks.DrinkHome>()
                                    if (previousBackStack != null) {
                                        navController.navigate(route = AppRoutes.Home.HomeScreen) {
                                            popUpTo(0) { inclusive = true }
                                            launchSingleTop = true
                                        }
                                    }
                                },
                            )
                        },
                    )
                },
            ) {
                when (val result = drink) {
                    DataState.Loading -> {
                        CircularLoading(modifier = Modifier.size(200.dp))
                    }

                    is DataState.Success -> {
                        DrinkDetailsScreen(
                            drink = result.data,
                            onDrinkDetailsEvent = drinksDetailsViewModel::onEvent,
                        )
                    }

                    is DataState.Error -> {
                        ErrorScreen(errorMessage = result.message)
                    }
                }
            }
        }
    }
}
