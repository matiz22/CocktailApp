package pl.matiz22.cocktailapp.android.core.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

@Composable
fun ErrorScreen(
    errorMessage: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(0.5f),
                painter = SharedRes.image.alert_octagon.painterResource(),
                contentDescription = errorMessage,
                tint = CocktailsAppTheme.colors.error,
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = errorMessage,
                style = CocktailsAppTheme.typography.heading1,
                color = CocktailsAppTheme.colors.error,
            )
        }
    }
}
