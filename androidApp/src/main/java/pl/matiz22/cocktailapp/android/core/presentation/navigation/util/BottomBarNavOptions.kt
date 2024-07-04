package pl.matiz22.cocktailapp.android.core.presentation.navigation.util

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptionsBuilder

fun bottomBarNavOption(navController: NavController): NavOptionsBuilder.() -> Unit = {
    popUpTo(navController.graph.findStartDestination().id) {
        saveState = true
    }
    launchSingleTop = true
    restoreState = true
}
