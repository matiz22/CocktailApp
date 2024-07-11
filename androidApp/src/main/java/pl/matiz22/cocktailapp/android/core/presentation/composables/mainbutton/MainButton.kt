package pl.matiz22.cocktailapp.android.core.presentation.composables.mainbutton

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.composables.appbar.AppBar
import pl.matiz22.cocktailapp.android.core.presentation.composables.texts.TitleAndDescription
import pl.matiz22.cocktailapp.android.core.presentation.composables.mainbutton.util.provideSizeForContentBasedOnFont
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    content: @Composable () -> Unit,

    ) {
    val alphaButton = if (enabled) 1f else 0.7f

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .alpha(alphaButton)
                .clickable(
                    enabled = enabled && !isLoading,
                    onClick = onClick,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                )
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            CocktailsAppTheme.colors.brand05,
                            CocktailsAppTheme.colors.accentBrand
                        ),
                        start = Offset.Zero,
                        end = Offset.Infinite
                    ), shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                if (!isLoading) {
                    content()
                } else {
                    CircularProgressIndicator(
                        modifier = Modifier.size(provideSizeForContentBasedOnFont()),
                        color = CocktailsAppTheme.colors.fontWhite,
                        strokeCap = StrokeCap.Round,
                        strokeWidth = 2.dp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainButtonPrev() {
    CocktailsAppTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(), color = CocktailsAppTheme.colors.background
        ) {
            var state by remember {
                mutableStateOf(true)
            }
            Scaffold(topBar = { AppBar(
                leftSideContent = {
                    TitleAndDescription(title = "Sample", description = "Sample")
                },
                rightSideContent = {

                }
            ) }) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    MainButton(onClick = { /*TODO*/ }, enabled = false) {
                        MainButtonText(text = "Main button")
                    }
                    MainButton(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        onClick = { state = !state }) {
                        MainButtonText(text = "Main button")
                    }
                    MainButton(onClick = { /*TODO*/ }, enabled = false, isLoading = true) {
                        MainButtonText(text = "Main button")
                    }
                    MainButton(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        onClick = { /*TODO*/ },
                        isLoading = true
                    ) {
                        MainButtonText(text = "Main button")
                    }
                    MainButton(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        onClick = { /*TODO*/ },
                        enabled = state
                    ) {
                        MainButtonText(text = "Main button")
                    }
                    MainButton(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        onClick = { /*TODO*/ },
                        enabled = state
                    ) {
                        MainButtonText(text = "Main button")
                        MainButtonIcon(painter = SharedRes.image.arrow_left.painterResource())
                    }
                }
            }
        }
    }
}
