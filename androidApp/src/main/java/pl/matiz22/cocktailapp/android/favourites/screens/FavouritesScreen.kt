package pl.matiz22.cocktailapp.android.favourites.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.matiz22.cocktailapp.android.drinks.composables.DrinkPosition
import pl.matiz22.cocktails.domain.model.Drink
import pl.matiz22.cocktails.domain.model.Drinks


@Composable
fun FavouritesScreen(
    modifier: Modifier = Modifier,
    favDrinks: Drinks,
    navToDetails: (Drink) -> Unit
) {
    Box(modifier = modifier) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(favDrinks.drinks) { item: Drink ->
                DrinkPosition(
                    drink = item,
                    withLike = true,
                    onClick = {
                        navToDetails(item)
                    }
                )
            }
        }
    }
}
