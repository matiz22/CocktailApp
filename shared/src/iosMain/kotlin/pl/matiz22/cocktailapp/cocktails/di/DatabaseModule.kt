package pl.matiz22.cocktailapp.cocktails.di

import org.koin.dsl.module
import pl.matiz22.cocktails.data.local.repository.DrinksLocalRepositoryImpl
import pl.matiz22.cocktails.data.local.source.getCocktailsDb
import pl.matiz22.cocktails.domain.repository.local.DrinksLocalRepository

fun databaseModule() =
    module {
        single {
            getCocktailsDb().cocktailDao()
        }
        single<DrinksLocalRepository> {
            DrinksLocalRepositoryImpl(get())
        }
    }
