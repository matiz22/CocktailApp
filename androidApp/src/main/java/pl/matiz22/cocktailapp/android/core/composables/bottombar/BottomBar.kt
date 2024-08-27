package pl.matiz22.cocktailapp.android.core.composables.bottombar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.composables.appbar.AppBar
import pl.matiz22.cocktailapp.android.core.composables.iconbutton.AppIconButton
import pl.matiz22.cocktailapp.android.core.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.core.navigation.model.NavItem
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navItems: List<NavItem> = emptyList(),
) {
    Box(modifier = modifier) {
        BottomBarBackground {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                navItems.forEach { navItem: NavItem ->
                    AppIconButton(
                        painter = navItem.icon,
                        onClick = navItem.navigate,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun BottomBarPrev() {
    CocktailsAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = CocktailsAppTheme.colors.background,
        ) {
            Scaffold(
                topBar = {
                    AppBar(
                        leftSideContent = {
                            TitleAndDescription(title = "Sample", description = "Sample")
                        },
                        rightSideContent = {
                            AppIconButton(painter = SharedRes.image.arrow_left.painterResource()) {
                            }
                            AppIconButton(painter = SharedRes.image.arrow_left.painterResource()) {
                            }
                        },
                    )
                },
                bottomBar = {
                    BottomBar()
                },
            ) {
                Column(
                    modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(it),
                ) {
                }
            }
        }
    }
}
