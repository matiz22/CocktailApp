package pl.matiz22.cocktailapp.android.search.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.composables.iconbutton.AppIconButton
import pl.matiz22.cocktailapp.android.core.presentation.composables.inputfield.InputTextField
import pl.matiz22.cocktailapp.android.core.presentation.composables.inputfield.LeftIconInputField
import pl.matiz22.cocktailapp.android.drinks.presentation.composables.DrinkPosition
import pl.matiz22.cocktailapp.android.search.presentation.events.SearchByNameEvents
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme
import pl.matiz22.cocktails.domain.model.Drink
import pl.matiz22.cocktails.domain.model.Drinks

@Composable
fun SearchByNameScreen(
    modifier: Modifier = Modifier,
    query: String,
    drinks: Drinks,
    onEvent: (SearchByNameEvents) -> Unit,
    pickResult: (Drink) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(CocktailsAppTheme.colors.background)
        ) {
            InputTextField(
                modifier = Modifier.padding(10.dp),
                value = query,
                onValueChange = { text ->
                    onEvent(SearchByNameEvents.UpdateQuery(text))
                },
                leftIcon = {
                    LeftIconInputField(painter = SharedRes.image.search.painterResource())
                },
                rightIcon = {
                    AppIconButton(
                        painter = SharedRes.image.x.painterResource(),
                        contentDescription = SharedRes.string.action_clear_description,
                        onClick = { onEvent(SearchByNameEvents.ClearQuery) }
                    )
                }
            )
            LazyColumn(
                contentPadding = PaddingValues(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                items(drinks.drinks) { drink: Drink ->
                    DrinkPosition(
                        drink = drink,
                        onClick = { pickResult(drink) }
                    )
                }

                item {
                    Spacer(modifier = Modifier.size(70.dp))
                }
            }
        }
    }
}
