package pl.matiz22.cocktailapp.android.home.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.drinks.composables.DrinkVerticalPosition
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme
import pl.matiz22.cocktails.domain.model.Drink
import pl.matiz22.cocktails.domain.model.Drinks

@Composable
fun RecentDrinks(
    drinks: Drinks,
    modifier: Modifier = Modifier,
    onDrinkClick: (Drink) -> Unit,
) {
    Surface(modifier = modifier, color = CocktailsAppTheme.colors.container) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = SharedRes.string.home_recent_drinks,
                style = CocktailsAppTheme.typography.heading3,
                color = CocktailsAppTheme.colors.font,
            )
            LazyRow {
                items(drinks.drinks) { drink ->
                    DrinkVerticalPosition(
                        modifier = Modifier.fillMaxSize(),
                        drink = drink,
                        onClick = { onDrinkClick(drink) },
                    )
                }
            }
        }
    }
}
