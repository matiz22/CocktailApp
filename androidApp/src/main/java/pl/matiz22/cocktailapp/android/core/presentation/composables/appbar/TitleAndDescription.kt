package pl.matiz22.cocktailapp.android.core.presentation.composables.appbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun TitleAndDescription(
    modifier: Modifier = Modifier,
    title: String,
    description: String
) {
    Box(modifier = modifier) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = title,
                style = CocktailsAppTheme.typography.heading1,
                color = CocktailsAppTheme.colors.font
            )
            Text(
                text = description,
                style = CocktailsAppTheme.typography.paragraphLarge,
                color = CocktailsAppTheme.colors.font
            )
        }
    }
}
