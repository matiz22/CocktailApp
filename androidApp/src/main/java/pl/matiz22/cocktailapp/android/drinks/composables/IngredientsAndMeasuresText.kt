package pl.matiz22.cocktailapp.android.drinks.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme
import pl.matiz22.cocktails.domain.model.Ingredient
import pl.matiz22.cocktails.domain.model.IngredientsAndMeasures
import pl.matiz22.cocktails.domain.model.Measure

@Composable
fun IngredientsAndMeasuresText(
    ingredientsAndMeasures: IngredientsAndMeasures,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = SharedRes.string.drinks_ingredients_and_measure_header,
            style = CocktailsAppTheme.typography.heading3,
            color = CocktailsAppTheme.colors.font,
        )
        Spacer(modifier = Modifier.size(10.dp))
        Column(
            modifier =
            Modifier.border(
                width = 2.dp,
                color = CocktailsAppTheme.colors.onBackground,
            ),
        ) {
            ingredientsAndMeasures.values.forEach { entry: Map.Entry<Ingredient, Measure> ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box(
                        modifier =
                        Modifier
                            .weight(1f)
                            .border(
                                width = 1.dp,
                                color = CocktailsAppTheme.colors.onBackground,
                            ),
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = entry.key.name,
                            style = CocktailsAppTheme.typography.paragraphSmall,
                            color = CocktailsAppTheme.colors.font,
                        )
                    }

                    Box(
                        modifier =
                        Modifier
                            .weight(1f)
                            .border(
                                width = 1.dp,
                                color = CocktailsAppTheme.colors.onBackground,
                            ),
                    ) {
                        Text(
                            modifier = Modifier.padding(4.dp),
                            text = entry.value.value,
                            style = CocktailsAppTheme.typography.paragraphSmall,
                            color = CocktailsAppTheme.colors.font,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}
