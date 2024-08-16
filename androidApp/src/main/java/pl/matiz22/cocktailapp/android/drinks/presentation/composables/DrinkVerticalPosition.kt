package pl.matiz22.cocktailapp.android.drinks.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme
import pl.matiz22.cocktails.domain.model.Drink

@Composable
fun DrinkVerticalPosition(
    modifier: Modifier = Modifier,
    drink: Drink,
    withLike: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(CocktailsAppTheme.colors.container)
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                modifier = Modifier
                    .padding(8.dp)
                    .background(
                        color = CocktailsAppTheme.colors.container,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .size(90.dp)
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
        if (withLike) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = if (drink.liked) {
                        SharedRes.image.heart_fill.painterResource()
                    } else {
                        SharedRes.image.heart_outline.painterResource()
                    },
                    contentDescription = if (drink.liked) {
                        SharedRes.string.drinks_liked
                    } else {
                        SharedRes.string.drinks_not_liked
                    },
                    tint = if (drink.liked) {
                        CocktailsAppTheme.colors.accentBrand
                    } else {
                        CocktailsAppTheme.colors.onContainer
                    }
                )

            }
        }
    }
}