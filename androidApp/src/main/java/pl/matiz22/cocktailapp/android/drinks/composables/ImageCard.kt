package pl.matiz22.cocktailapp.android.drinks.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme
import pl.matiz22.cocktails.domain.model.Drink
import pl.matiz22.cocktails.domain.model.Ingredient
import pl.matiz22.cocktails.domain.model.IngredientsAndMeasures
import pl.matiz22.cocktails.domain.model.Measure

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    source: String
) {
    Box(modifier = modifier) {
        AsyncImage(
            modifier = Modifier
                .background(color = CocktailsAppTheme.colors.monochromatic04)
                .fillMaxWidth()
                .aspectRatio(1f),
            model = ImageRequest.Builder(LocalContext.current)
                .data(source)
                .crossfade(true)
                .build(),
            contentDescription = source,
            colorFilter = ColorFilter.tint(
                color = CocktailsAppTheme.colors.container.copy(0.5f),
                blendMode = BlendMode.Darken
            ),
            contentScale = ContentScale.FillBounds,
            placeholder = SharedRes.image.drink_icon.painterResource(),
            error = SharedRes.image.drink_icon.painterResource()
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        startY = 0.0f,
                        endY = 600.0f,
                        colors = listOf(
                            CocktailsAppTheme.colors.monochromatic04.copy(0.6f),
                            Color.Transparent
                        )
                    )
                )
        )
    }
}

@Preview
@Composable
private fun PrevImageCard() {
    val fakeDrink = Drink(
        id = "12345",
        name = "Mojito",
        category = "Cocktail",
        alcoholic = "Alcoholic",
        glass = "Highball glass",
        instructions = "Muddle mint leaves with sugar and lime juice. Add a splash of soda water and fill the glass with cracked ice. Pour the rum and top with soda water. Garnish and serve with straw.",
        image = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
        ingredientsAndMeasures = IngredientsAndMeasures(
            values = mapOf(
                Ingredient("White rum") to Measure("2 oz"),
                Ingredient("Sugar") to Measure("2 tsp"),
                Ingredient("Lime juice") to Measure("1 oz"),
                Ingredient("Soda water") to Measure("To top"),
                Ingredient("Mint") to Measure("4-5 leaves")
            )
        )
    )
    CocktailsAppTheme {
        Column {
            ImageCard(
                source = fakeDrink.image,
            )
        }
    }
}
