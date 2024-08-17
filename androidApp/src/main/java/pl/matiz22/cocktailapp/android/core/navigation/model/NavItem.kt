package pl.matiz22.cocktailapp.android.core.navigation.model

import androidx.compose.ui.graphics.painter.Painter

data class NavItem(
    val icon: Painter,
    val title: String,
    val contentDescription: String?,
    val navigate: () -> Unit
)
