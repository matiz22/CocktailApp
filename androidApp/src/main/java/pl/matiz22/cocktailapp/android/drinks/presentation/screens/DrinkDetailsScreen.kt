package pl.matiz22.cocktailapp.android.drinks.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import pl.matiz22.cocktailapp.android.drinks.presentation.composables.DrinkInfo
import pl.matiz22.cocktailapp.android.drinks.presentation.composables.DrinkInstructions
import pl.matiz22.cocktailapp.android.drinks.presentation.composables.ImageCard
import pl.matiz22.cocktailapp.android.drinks.presentation.composables.IngredientsAndMeasuresText
import pl.matiz22.cocktailapp.cocktails.domain.model.Drink

@Composable
fun DrinkDetailsScreen(
    modifier: Modifier = Modifier,
    drink: Drink,
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
                DrinkInfo(drink = drink)
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
