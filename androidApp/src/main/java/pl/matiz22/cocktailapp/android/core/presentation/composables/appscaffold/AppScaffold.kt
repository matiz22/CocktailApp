package pl.matiz22.cocktailapp.android.core.presentation.composables.appscaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    transparentMode: Boolean = false,
    snackbarHostState: SnackbarHostState? = null,
    topAppbar: @Composable() (() -> Unit)? = null,
    bottomAppbar: @Composable() (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(CocktailsAppTheme.colors.background),
        snackbarHost = {
            if (snackbarHostState != null) {
                SnackbarHost(hostState = snackbarHostState)
            }
        },
        topBar = {
            topAppbar?.invoke()
        },
        bottomBar = {
            bottomAppbar?.invoke()
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(CocktailsAppTheme.colors.background)
                .padding(
                    top = if(!transparentMode) paddingValues.calculateTopPadding() else 0.dp
                )
        ) {
            content()
        }
    }
}
