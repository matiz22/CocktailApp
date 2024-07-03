package pl.matiz22.cocktailapp.android.core.presentation.composables.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun BottomBarBackground(
    modifier: Modifier = Modifier,
    content: @Composable() () -> Unit
) {
    Box(modifier = modifier) {
        if (isSystemInDarkTheme()) {
            Box(
                modifier = Modifier
                    .alpha(0.8f)
                    .background(CocktailsAppTheme.colors.background)
            ) {
                content()
            }
        } else {
            Box(modifier = Modifier.background(CocktailsAppTheme.colors.background)) {
                content()
            }
        }
    }
}
