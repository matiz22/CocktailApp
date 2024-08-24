package pl.matiz22.cocktailapp.android.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import pl.matiz22.cocktailapp.android.R

val provider =
    GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs,
    )
val fontName = GoogleFont("Gothic A1")

val fontFamily =
    FontFamily(
        Font(googleFont = fontName, fontProvider = provider),
    )

@Immutable
data class CocktailsTypography(
    val heading1: TextStyle =
        TextStyle(
            fontFamily = fontFamily,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
        ),
    val heading2: TextStyle =
        TextStyle(
            fontFamily = fontFamily,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 28.sp,
        ),
    val heading3: TextStyle =
        TextStyle(
            fontFamily = fontFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
        ),
    val heading4: TextStyle =
        TextStyle(
            fontFamily = fontFamily,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
        ),
    val heading5: TextStyle =
        TextStyle(
            fontFamily = fontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
        ),
    val heading6: TextStyle =
        TextStyle(
            fontFamily = fontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
        ),
    val paragraphLarge: TextStyle =
        TextStyle(
            fontFamily = fontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp,
        ),
    val paragraphSmall: TextStyle =
        TextStyle(
            fontFamily = fontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp,
        ),
)
