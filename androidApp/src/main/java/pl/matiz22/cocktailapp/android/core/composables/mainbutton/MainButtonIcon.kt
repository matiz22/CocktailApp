package pl.matiz22.cocktailapp.android.core.composables.mainbutton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import pl.matiz22.cocktailapp.android.core.composables.mainbutton.util.provideSizeForContentBasedOnFont
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun MainButtonIcon(
    painter: Painter,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {
    Box(modifier = modifier) {
        Icon(
            modifier = Modifier.size(provideSizeForContentBasedOnFont()),
            painter = painter,
            contentDescription = contentDescription,
            tint = CocktailsAppTheme.colors.fontWhite,
        )
    }
}
