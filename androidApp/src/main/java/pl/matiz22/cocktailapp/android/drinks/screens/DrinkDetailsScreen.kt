package pl.matiz22.cocktailapp.android.drinks.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.composables.iconbutton.AppIconButton
import pl.matiz22.cocktailapp.android.drinks.composables.DrinkInfo
import pl.matiz22.cocktailapp.android.drinks.composables.DrinkInstructions
import pl.matiz22.cocktailapp.android.drinks.composables.ImageCard
import pl.matiz22.cocktailapp.android.drinks.composables.IngredientsAndMeasuresText
import pl.matiz22.cocktailapp.android.drinks.events.DrinkDetailsEvent
import pl.matiz22.cocktails.domain.model.Drink

@Composable
fun DrinkDetailsScreen(
    modifier: Modifier = Modifier,
    drink: Drink,
    onDrinkDetailsEvent: (DrinkDetailsEvent) -> Unit,
    lazyListState: LazyListState = rememberLazyListState(),
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = lazyListState,
            contentPadding = PaddingValues(
                start = 6.dp,
                end = 6.dp,
                bottom = 6.dp
            ),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                ImageCard(
                    modifier = Modifier
                        .layout { measurable, constraints ->
                            val placeable = measurable.measure(
                                constraints.copy(
                                    maxWidth = constraints.maxWidth + 12.dp.roundToPx()
                                )
                            )
                            layout(placeable.width, placeable.height) {
                                placeable.place(0, 0)
                            }
                        },
                    source = drink.image
                )
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DrinkInfo(drink = drink)
                    when (drink.liked) {
                        true -> AppIconButton(
                            painter = SharedRes.image.heart_fill.painterResource(),
                            onClick = { onDrinkDetailsEvent(DrinkDetailsEvent.FavouriteClicked) })

                        false -> AppIconButton(
                            painter = SharedRes.image.heart_outline.painterResource(),
                            onClick = { onDrinkDetailsEvent(DrinkDetailsEvent.FavouriteClicked) })
                    }
                }
            }
            item {
                IngredientsAndMeasuresText(ingredientsAndMeasures = drink.ingredientsAndMeasures)
            }
            item {
                DrinkInstructions(drink.instructions)
            }
        }
    }
}
