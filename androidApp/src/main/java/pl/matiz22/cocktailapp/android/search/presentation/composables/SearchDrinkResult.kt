package pl.matiz22.cocktailapp.android.search.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme
import pl.matiz22.cocktailapp.cocktails.domain.model.Drink
import pl.matiz22.cocktailapp.cocktails.domain.model.Ingredient
import pl.matiz22.cocktailapp.cocktails.domain.model.IngredientsAndMeasures
import pl.matiz22.cocktailapp.cocktails.domain.model.Measure

@Composable
fun SearchDrinkResult(
    modifier: Modifier = Modifier,
    drink: Drink,
    onClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = CocktailsAppTheme.colors.background)
            .then(
                if (onClick != null) {
                    Modifier.clickable(
                        onClick = onClick,
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple()
                    )
                } else {
                    Modifier
                }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(8.dp)
                    .background(
                        color = CocktailsAppTheme.colors.container,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(drink.image)
                    .crossfade(true)
                    .build(),
                contentDescription = drink.image,
                placeholder = SharedRes.image.drink_icon.painterResource(),
                error = SharedRes.image.drink_icon.painterResource()
            )
            TitleAndDescription(title = drink.name, description = drink.category)
        }
    }
}

@Preview
@Composable
private fun PrevSearchDrinkResult() {
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
            SearchDrinkResult(
                drink = fakeDrink,
                onClick = {}
            )
            SearchDrinkResult(
                drink = fakeDrink.copy(image = ""),
                onClick = {}
            )
        }
    }
}
