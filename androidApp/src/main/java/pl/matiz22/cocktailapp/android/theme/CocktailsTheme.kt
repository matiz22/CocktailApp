package pl.matiz22.cocktailapp.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalCocktailsTypography =
    staticCompositionLocalOf {
        CocktailsTypography()
    }

val LocalCocktailsColors =
    staticCompositionLocalOf {
        CocktailsColors(
            font = Color.Unspecified,
            background = Color.Unspecified,
            container = Color.Unspecified,
            onBackground = Color.Unspecified,
            onContainer = Color.Unspecified,
        )
    }

@Composable
fun CocktailsAppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors =
        if (isDarkTheme) {
            CocktailsColors(
                font = AppColors.FontWhite.color,
                background = AppColors.Monochromatic01.color,
                container = AppColors.Monochromatic02.color,
                onBackground = AppColors.Monochromatic10.color,
                onContainer = AppColors.Monochromatic10.color,
            )
        } else {
            CocktailsColors(
                font = AppColors.FontDark.color,
                background = AppColors.Monochromatic09.color,
                container = AppColors.Monochromatic10.color,
                onBackground = AppColors.Monochromatic01.color,
                onContainer = AppColors.Monochromatic01.color,
            )
        }
    val typography = CocktailsTypography()
    CompositionLocalProvider(
        LocalCocktailsColors provides colors,
        LocalCocktailsTypography provides typography,
        content = content,
    )
}

object CocktailsAppTheme {
    val colors: CocktailsColors
        @Composable
        get() = LocalCocktailsColors.current
    val typography: CocktailsTypography
        @Composable
        get() = LocalCocktailsTypography.current
}
