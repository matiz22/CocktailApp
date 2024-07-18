package pl.matiz22.cocktailapp.android.core.presentation.composables.mainbutton.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun provideSizeForContentBasedOnFont() = with(LocalDensity.current) {
    CocktailsAppTheme.typography.paragraphLarge.fontSize.toDp()
}
