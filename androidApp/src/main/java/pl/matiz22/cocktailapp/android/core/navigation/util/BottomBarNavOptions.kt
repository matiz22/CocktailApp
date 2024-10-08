package pl.matiz22.cocktailapp.android.core.navigation.util

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptionsBuilder

internal fun bottomBarNavOption(navController: NavController): NavOptionsBuilder.() -> Unit =
    {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
