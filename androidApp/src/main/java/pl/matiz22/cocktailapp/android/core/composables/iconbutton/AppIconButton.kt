package pl.matiz22.cocktailapp.android.core.composables.iconbutton

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun AppIconButton(
    painter: Painter,
    modifier: Modifier = Modifier,
    tint: Color = CocktailsAppTheme.colors.onBackground,
    contentDescription: String? = null,
    onClick: () -> Unit,
) {
    Box(modifier = modifier) {
        IconButton(
            modifier = Modifier,
            onClick = onClick,
            colors =
            IconButtonDefaults.iconButtonColors(
                contentColor = CocktailsAppTheme.colors.onBackground,
            ),
        ) {
            Icon(
                painter = painter,
                tint = tint,
                contentDescription = contentDescription,
            )
        }
    }
}
