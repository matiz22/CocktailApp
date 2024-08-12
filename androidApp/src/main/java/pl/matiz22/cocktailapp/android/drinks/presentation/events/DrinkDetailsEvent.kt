package pl.matiz22.cocktailapp.android.drinks.presentation.events

sealed class DrinkDetailsEvent {
    data object FavouriteClicked: DrinkDetailsEvent()
}
