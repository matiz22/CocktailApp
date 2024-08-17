package pl.matiz22.cocktailapp.android.search.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.matiz22.cocktailapp.android.search.viewmodels.SearchByNameViewModel

fun searchViewModelsModule() = module {
    viewModel { SearchByNameViewModel(drinksRepository = get()) }
}
