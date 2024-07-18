package pl.matiz22.cocktailapp.android.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color


sealed class AppColors {
    abstract val color: Color

    data object Monochromatic01 : AppColors() {
        override val color = Color(0xFF1A1A1A)
    }

    data object Monochromatic02 : AppColors() {
        override val color = Color(0xFF333333)
    }

    data object Monochromatic03 : AppColors() {
        override val color = Color(0xFF4D4D4D)
    }

    data object Monochromatic04 : AppColors() {
        override val color = Color(0xFF666666)
    }

    data object Monochromatic05 : AppColors() {
        override val color = Color(0xFF808080)
    }

    data object Monochromatic06 : AppColors() {
        override val color = Color(0xFF999999)
    }

    data object Monochromatic07 : AppColors() {
        override val color = Color(0xFFB2B2B2)
    }

    data object Monochromatic08 : AppColors() {
        override val color = Color(0xFFCCCCCC)
    }

    data object Monochromatic09 : AppColors() {
        override val color = Color(0xFFF2F2F2)
    }

    data object Monochromatic10 : AppColors() {
        override val color = Color(0xFFFFFFFF)
    }

    data object Brand01 : AppColors() {
        override val color = Color(0xFF1F0D26)
    }

    data object Brand02 : AppColors() {
        override val color = Color(0xFF3E1A4D)
    }

    data object Brand03 : AppColors() {
        override val color = Color(0xFF5D2673)
    }

    data object Brand04 : AppColors() {
        override val color = Color(0xFF7C3399)
    }

    data object Brand05 : AppColors() {
        override val color = Color(0xFF9B40BF)
    }

    data object Brand06 : AppColors() {
        override val color = Color(0xFFAF66CC)
    }

    data object Brand07 : AppColors() {
        override val color = Color(0xFFC38CD9)
    }

    data object Brand08 : AppColors() {
        override val color = Color(0xFFD7B2E5)
    }

    data object Brand09 : AppColors() {
        override val color = Color(0xFFEBD9F2)
    }

    data object Brand10 : AppColors() {
        override val color = Color(0xFFF5ECF9)
    }

    data object Neutral : AppColors() {
        override val color = Color(0xFF4B92D4)
    }

    data object Success : AppColors() {
        override val color = Color(0xFF4DCFC0)
    }

    data object Warning : AppColors() {
        override val color = Color(0xFFEEA63A)
    }

    data object Error : AppColors() {
        override val color = Color(0xFFE52B67)
    }

    data object FontDark : AppColors() {
        override val color = Color(0xFF0F0F0F)
    }

    data object FontMid : AppColors() {
        override val color = Color(0xFF878787)
    }

    data object FontLight : AppColors() {
        override val color = Color(0xFFBEBEBE)
    }

    data object FontWhite : AppColors() {
        override val color = Color.White
    }

    data object BrandAccent : AppColors() {
        override val color: Color = Color(0xFFF344F7)
    }
}

@Immutable
data class CocktailsColors(
    val monochromatic01: Color = AppColors.Monochromatic01.color,
    val monochromatic02: Color = AppColors.Monochromatic02.color,
    val monochromatic03: Color = AppColors.Monochromatic03.color,
    val monochromatic04: Color = AppColors.Monochromatic04.color,
    val monochromatic05: Color = AppColors.Monochromatic05.color,
    val monochromatic06: Color = AppColors.Monochromatic06.color,
    val monochromatic07: Color = AppColors.Monochromatic07.color,
    val monochromatic08: Color = AppColors.Monochromatic08.color,
    val monochromatic09: Color = AppColors.Monochromatic09.color,
    val monochromatic10: Color = AppColors.Monochromatic10.color,
    val brand01: Color = AppColors.Brand01.color,
    val brand02: Color = AppColors.Brand02.color,
    val brand03: Color = AppColors.Brand03.color,
    val brand04: Color = AppColors.Brand04.color,
    val brand05: Color = AppColors.Brand05.color,
    val brand06: Color = AppColors.Brand06.color,
    val brand07: Color = AppColors.Brand07.color,
    val brand08: Color = AppColors.Brand08.color,
    val brand09: Color = AppColors.Brand09.color,
    val brand10: Color = AppColors.Brand10.color,
    val neutral: Color = AppColors.Neutral.color,
    val success: Color = AppColors.Success.color,
    val warning: Color = AppColors.Warning.color,
    val error: Color = AppColors.Error.color,
    val fontDark: Color = AppColors.FontDark.color,
    val fontMid: Color = AppColors.FontMid.color,
    val fontLight: Color = AppColors.FontLight.color,
    val fontWhite: Color = AppColors.FontWhite.color,
    val font: Color,
    val background: Color,
    val container: Color,
    val onBackground: Color,
    val onContainer: Color,
    val accentBrand: Color = AppColors.BrandAccent.color
)
