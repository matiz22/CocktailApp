package pl.matiz22.cocktailapp.android.core.composables.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun BottomBarBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .then(
                    if (isSystemInDarkTheme()) Modifier.alpha(0.8f) else Modifier
                )
                .background(CocktailsAppTheme.colors.container)
        ) {
            content()
        }
    }
}
