package pl.matiz22.cocktailapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.composables.appbar.AppBar
import pl.matiz22.cocktailapp.android.core.composables.appscaffold.AppScaffold
import pl.matiz22.cocktailapp.android.core.composables.iconbutton.AppIconButton
import pl.matiz22.cocktailapp.android.core.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.core.screens.SettingsScreen
import pl.matiz22.cocktailapp.android.core.viewmodels.SettingsViewModel
import pl.matiz22.cocktailapp.android.drinks.graph.drinksGraph
import pl.matiz22.cocktailapp.android.favourites.graph.favouritesGraph
import pl.matiz22.cocktailapp.android.home.presentation.graph.homeGraph
import pl.matiz22.cocktailapp.android.search.graph.searchGraph
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CocktailsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CocktailsAppTheme.colors.background,
                ) {
                    NavHost(
                        modifier =
                        Modifier
                            .fillMaxSize()
                            .background(CocktailsAppTheme.colors.background),
                        navController = navController,
                        startDestination = AppRoutes.Home,
                    ) {
                        homeGraph(navController)
                        searchGraph(navController)
                        favouritesGraph(navController)
                        drinksGraph(navController)
                        composable<AppRoutes.Settings> { navBackStackEntry ->
                            val settingsViewModel =
                                viewModel<SettingsViewModel>(viewModelStoreOwner = navBackStackEntry)
                            val timePickerState by settingsViewModel.dailyDrinkTime.collectAsStateWithLifecycle()
                            val dialogState by settingsViewModel.dailyDrinkPicker
                            AppScaffold(
                                topAppbar = {
                                    AppBar(
                                        leftSideContent = {
                                            AppIconButton(
                                                painter = SharedRes.image.arrow_left.painterResource(),
                                                onClick = { navController.navigateUp() },
                                            )
                                        },
                                        rightSideContent = {
                                            Text(
                                                text = stringResource(R.string.settings_screen_title),
                                                style = CocktailsAppTheme.typography.heading1,
                                            )
                                        },
                                    )
                                },
                            ) {
                                SettingsScreen(
                                    dailyDrinkTimeState = timePickerState,
                                    dialogState = dialogState,
                                    onEvent = settingsViewModel::onEvent,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
