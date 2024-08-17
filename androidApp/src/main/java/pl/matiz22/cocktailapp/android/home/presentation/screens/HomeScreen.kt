package pl.matiz22.cocktailapp.android.home.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.matiz22.cocktailapp.android.home.composables.RecentDrinks
import pl.matiz22.cocktails.domain.model.Drink
import pl.matiz22.cocktails.domain.model.Drinks

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    recentDrinks: Drinks,
    navigateToDetails: (Drink) -> Unit,
) {
    Box(modifier = modifier) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                RecentDrinks(drinks = recentDrinks, onDrinkClick = navigateToDetails)
            }
        }
    }
}
