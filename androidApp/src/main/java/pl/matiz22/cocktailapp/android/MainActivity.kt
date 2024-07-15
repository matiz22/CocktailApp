package pl.matiz22.cocktailapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import io.github.skeptick.libres.compose.painterResource
import org.koin.androidx.viewmodel.ext.android.getViewModel
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.composables.appbar.AppBar
import pl.matiz22.cocktailapp.android.core.presentation.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.core.presentation.composables.bottombar.BottomBar
import pl.matiz22.cocktailapp.android.core.presentation.composables.iconbutton.AppIconButton
import pl.matiz22.cocktailapp.android.core.presentation.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.core.presentation.navigation.util.navItems
import pl.matiz22.cocktailapp.android.drinks.presentation.graph.drinksGraph
import pl.matiz22.cocktailapp.android.favourites.presentation.graph.favouritesGraph
import pl.matiz22.cocktailapp.android.home.presentation.graph.homeGraph
import pl.matiz22.cocktailapp.android.search.presentation.graph.searchGraph
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CocktailsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CocktailsAppTheme.colors.background
                ) {
                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(CocktailsAppTheme.colors.background),
                        navController = navController,
                        startDestination = AppRoutes.Home
                    ) {
                        homeGraph(navController)
                        searchGraph(navController)
                        favouritesGraph(navController)
                        drinksGraph(navController)
                    }
                }
            }
        }
    }
}
