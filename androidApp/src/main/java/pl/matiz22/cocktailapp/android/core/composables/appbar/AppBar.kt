package pl.matiz22.cocktailapp.android.core.composables.appbar

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.core.presentation.composables.iconbutton.AppIconButton
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme


@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    color: Color? = null,
    leftSideContent: @Composable() () -> Unit = {},
    rightSideContent: @Composable() () -> Unit = {}
) {
    Surface(
        modifier = modifier,
        color = color ?: CocktailsAppTheme.colors.container,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                leftSideContent()
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                rightSideContent()
            }
        }
    }
}

@Preview
@PreviewLightDark
@Composable
private fun AppBarPrev() {
    CocktailsAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = CocktailsAppTheme.colors.background
        ) {
            Scaffold(topBar = {
                AppBar(
                    leftSideContent = {
                        TitleAndDescription(title = "Sample", description = "Sample")
                    },
                    rightSideContent = {
                        AppIconButton(painter = SharedRes.image.arrow_left.painterResource()) {

                        }
                        AppIconButton(painter = SharedRes.image.arrow_left.painterResource()) {

                        }
                    }
                )
            }) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {

                }
            }
        }
    }
}
