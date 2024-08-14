package pl.matiz22.cocktailapp.android.home.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.matiz22.cocktailapp.android.home.viewmodels.HomeScreenViewModel

fun homeViewModelModule() = module {
    viewModel { HomeScreenViewModel(get()) }
}