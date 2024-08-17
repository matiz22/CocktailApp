package pl.matiz22.cocktailapp.android.favourites.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.matiz22.cocktailapp.android.favourites.viewmodels.FavouritesScreenViewModel

fun favViewModelModule() = module {
    viewModel { FavouritesScreenViewModel(get()) }
}
