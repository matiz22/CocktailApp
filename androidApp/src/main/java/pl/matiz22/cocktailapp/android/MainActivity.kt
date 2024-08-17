package pl.matiz22.cocktailapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import pl.matiz22.cocktailapp.android.core.navigation.route.AppRoutes
import pl.matiz22.cocktailapp.android.drinks.graph.drinksGraph
import pl.matiz22.cocktailapp.android.favourites.graph.favouritesGraph
import pl.matiz22.cocktailapp.android.home.presentation.graph.homeGraph
import pl.matiz22.cocktailapp.android.search.graph.searchGraph
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
