package pl.matiz22.cocktailapp.cocktails.di

import org.koin.dsl.module

fun cocktailsViewModelsModule() = module {
    includes(cocktailsDataModule())
}
