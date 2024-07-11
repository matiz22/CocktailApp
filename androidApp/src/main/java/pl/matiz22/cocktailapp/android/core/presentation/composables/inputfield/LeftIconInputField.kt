package pl.matiz22.cocktailapp.android.core.presentation.composables.inputfield

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun LeftIconInputField(
    modifier: Modifier = Modifier,
    painter: Painter,
    tint: Color = CocktailsAppTheme.colors.onBackground
) {
    Box(
        modifier = Modifier.size(48.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = modifier
                .size(24.dp),
            painter = painter,
            contentDescription = null,
            tint = tint
        )
    }
}