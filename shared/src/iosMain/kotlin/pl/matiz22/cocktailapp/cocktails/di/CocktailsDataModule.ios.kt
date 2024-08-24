package pl.matiz22.cocktailapp.cocktails.di

import org.koin.dsl.module
import pl.matiz22.cocktails.data.local.source.getCocktailsDb

fun cocktailsLocalDataModule() =
    module {
        single { getCocktailsDb() }
    }
