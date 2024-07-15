package pl.matiz22.cocktailapp.android.core.presentation.navigation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import io.github.skeptick.libres.compose.painterResource
import pl.matiz22.cocktailapp.SharedRes
import pl.matiz22.cocktailapp.android.core.presentation.navigation.model.NavItem
import pl.matiz22.cocktailapp.android.core.presentation.navigation.route.AppRoutes

@Composable
fun navItems(navController: NavController) = listOf(
    NavItem(
        icon = SharedRes.image.home.painterResource(),
        title = SharedRes.string.nav_home,
        contentDescription = SharedRes.string.nav_home_description,
        navigate = {
            navController.navigate(
                route = AppRoutes.Home,
                builder = bottomBarNavOption(navController)
            )
        }
    ),
    NavItem(
        icon = SharedRes.image.search.painterResource(),
        title = SharedRes.string.nav_home,
        contentDescription = SharedRes.string.nav_home_description,
        navigate = {
            navController.navigate(
                route = AppRoutes.Search,
                builder = bottomBarNavOption(navController)
            )
        }
    ),
    NavItem(
        icon = SharedRes.image.heart_outline.painterResource(),
        title = SharedRes.string.nav_favourite,
        contentDescription = SharedRes.string.nav_home_description,
        navigate = {
            navController.navigate(
                route = AppRoutes.Favourites,
                builder = bottomBarNavOption(navController)
            )
        }
    )
)
