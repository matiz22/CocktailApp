package pl.matiz22.cocktailapp.cocktails.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.matiz22.cocktailapp.cocktails.presentation.viewmodels.DrinksViewModel

fun cocktailsViewModelsModule() = module {
    includes(cocktailsDataModule())
    viewModel { DrinksViewModel(get()) }
}
