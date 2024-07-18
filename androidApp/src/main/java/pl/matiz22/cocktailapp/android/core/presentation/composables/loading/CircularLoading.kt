package pl.matiz22.cocktailapp.android.core.presentation.composables.loading

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun CircularLoading(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = CocktailsAppTheme.colors.onBackground,
        strokeCap = StrokeCap.Round,
        strokeWidth = 2.dp
    )
}
