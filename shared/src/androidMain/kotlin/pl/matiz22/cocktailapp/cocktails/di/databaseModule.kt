package pl.matiz22.cocktailapp.cocktails.di

import android.content.Context
import org.koin.dsl.module

fun databaseModule(context: Context) = module {
    single {
        getCocktailsDb(context).cocktailDao()
    }
    single<DrinksLocalRepository> {
        DrinksLocalRepositoryImpl(get())
    }
}
