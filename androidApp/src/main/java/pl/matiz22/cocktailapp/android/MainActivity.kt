package pl.matiz22.cocktailapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import pl.matiz22.cocktailapp.android.theme.CocktailsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CocktailsAppTheme.colors.background
                ) {

                }
            }
        }
    }
}
