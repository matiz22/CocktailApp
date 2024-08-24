package pl.matiz22.cocktailapp.android.core.composables.inputfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.composables.iconbutton.AppIconButton
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun InputTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    error: String? = null,
    singleLine: Boolean = false,
    minLines: Int = 1,
    maxLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leftIcon: (@Composable () -> Unit)? = null,
    rightIcon: (@Composable () -> Unit)? = null,
) {
    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        minLines = minLines,
        maxLines = maxLines,
        textStyle = CocktailsAppTheme.typography.paragraphLarge.copy(color = CocktailsAppTheme.colors.font),
        visualTransformation = visualTransformation,
        cursorBrush =
        Brush.linearGradient(
            listOf(
                CocktailsAppTheme.colors.onBackground,
                CocktailsAppTheme.colors.onBackground,
            ),
        ),
        decorationBox = { innerTextField ->
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                Text(
                    text = label ?: "",
                    style = CocktailsAppTheme.typography.paragraphLarge,
                    color = CocktailsAppTheme.colors.font,
                )
                Box(
                    modifier =
                    Modifier
                        .clip(CircleShape)
                        .fillMaxWidth()
                        .background(color = CocktailsAppTheme.colors.container)
                        .then(
                            if (error != null) {
                                Modifier
                                    .background(color = CocktailsAppTheme.colors.container)
                                    .border(
                                        width = 2.dp,
                                        color = CocktailsAppTheme.colors.error,
                                        shape = CircleShape,
                                    )
                            } else {
                                Modifier
                                    .background(color = CocktailsAppTheme.colors.error.copy(alpha = 0.05f))
                                    .border(
                                        width = 2.dp,
                                        brush =
                                        Brush.linearGradient(
                                            colors =
                                            listOf(
                                                CocktailsAppTheme.colors.brand05,
                                                CocktailsAppTheme.colors.accentBrand,
                                            ),
                                        ),
                                        shape = CircleShape,
                                    )
                            },
                        ),
                ) {
                    Row(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            if (leftIcon != null) {
                                leftIcon()
                            } else {
                                Spacer(modifier = Modifier.size(48.dp))
                            }
                            if (value != "") {
                                innerTextField()
                            } else {
                                Text(
                                    text = placeholder ?: "",
                                    style = CocktailsAppTheme.typography.paragraphLarge,
                                    color =
                                    if (isSystemInDarkTheme()) {
                                        CocktailsAppTheme.colors.fontLight
                                    } else {
                                        CocktailsAppTheme.colors.fontMid
                                    },
                                )
                            }
                        }
                        if (rightIcon != null) {
                            rightIcon()
                        } else {
                            Spacer(modifier = Modifier.size(48.dp))
                        }
                    }
                }
                Text(
                    text = error ?: "",
                    style = CocktailsAppTheme.typography.paragraphSmall,
                    color = CocktailsAppTheme.colors.error,
                )
            }
        },
    )
}

@Preview
@Composable
private fun PrevInputTextField() {
    var text by remember {
        mutableStateOf(
            "test",
        )
    }
    CocktailsAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black,
        ) {
            Scaffold(
                modifier =
                Modifier
                    .fillMaxSize()
                    .background(CocktailsAppTheme.colors.background),
            ) { paddingValues ->
                Column(
                    modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                ) {
                    InputTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = "Test",
                        placeholder = "Test",
                        error = "Test",
                    )
                    InputTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = "Test",
                        placeholder = "Test",
                    )
                    InputTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = "Test",
                        placeholder = "Test",
                        maxLines = 3,
                        leftIcon = {
                            AppIconButton(
                                painter = SharedRes.image.search.painterResource(),
                            ) {
                            }
                        },
                    )
                    InputTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = "Test",
                        placeholder = "Test",
                        visualTransformation = PasswordVisualTransformation('*'),
                        leftIcon = {
                            LeftIconInputField(painter = SharedRes.image.search.painterResource())
                        },
                        rightIcon = {
                            AppIconButton(
                                painter = SharedRes.image.search.painterResource(),
                            ) {
                            }
                        },
                    )
                }
            }
        }
    }
}
