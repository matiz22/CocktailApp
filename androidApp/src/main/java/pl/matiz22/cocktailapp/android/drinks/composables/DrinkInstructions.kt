package pl.matiz22.cocktailapp.android.drinks.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun DrinkInstructions(
    instructions: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = SharedRes.string.drinks_instructions_header,
            style = CocktailsAppTheme.typography.heading3,
            color = CocktailsAppTheme.colors.font,
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = instructions,
            style = CocktailsAppTheme.typography.paragraphSmall,
            color = CocktailsAppTheme.colors.font,
        )
    }
}
