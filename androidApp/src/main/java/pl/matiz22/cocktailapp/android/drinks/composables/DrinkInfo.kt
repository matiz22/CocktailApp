package pl.matiz22.cocktailapp.android.drinks.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.matiz22.cocktailapp.android.core.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme
import pl.matiz22.cocktails.domain.model.Drink

@Composable
fun DrinkInfo(
    drink: Drink,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        TitleAndDescription(
            title = drink.name,
            description = drink.category,
        )
        Text(
            text = drink.alcoholic,
            style = CocktailsAppTheme.typography.paragraphLarge,
            color = CocktailsAppTheme.colors.fontLight,
        )
        Text(
            text = drink.glass,
            style = CocktailsAppTheme.typography.paragraphLarge,
            color = CocktailsAppTheme.colors.fontLight,
        )
    }
}
