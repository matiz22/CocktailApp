package pl.matiz22.cocktailapp.android.drinks.events

sealed class DrinkDetailsEvent {
    data object FavouriteClicked : DrinkDetailsEvent()
}
