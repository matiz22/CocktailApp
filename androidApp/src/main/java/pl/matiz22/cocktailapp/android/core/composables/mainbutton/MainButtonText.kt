package pl.matiz22.cocktailapp.android.core.composables.mainbutton

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun MainButtonText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = text,
        style = CocktailsAppTheme.typography.paragraphLarge,
        color = CocktailsAppTheme.colors.fontWhite,
    )
}
