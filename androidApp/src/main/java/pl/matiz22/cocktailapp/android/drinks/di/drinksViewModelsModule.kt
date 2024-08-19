package pl.matiz22.cocktailapp.android.drinks.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.matiz22.cocktailapp.android.drinks.viewmodels.DrinkDetailsViewModel

fun drinksViewModelsModule() =
    module {
        viewModel { parameters ->
            DrinkDetailsViewModel(
                drinkId = parameters.get(),
                drinksRepository = get(),
                drinksLocalRepository = get(),
            )
        }
    }
