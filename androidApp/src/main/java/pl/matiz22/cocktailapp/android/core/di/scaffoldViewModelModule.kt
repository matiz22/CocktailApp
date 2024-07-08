package pl.matiz22.cocktailapp.android.core.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.matiz22.cocktailapp.android.core.presentation.viewmodels.ScaffoldViewModel
import pl.matiz22.cocktailapp.core.di.navHeadersModule

fun scaffoldViewModelModule() = module {
    includes(navHeadersModule())
    viewModel { ScaffoldViewModel(get(), get()) }
}
