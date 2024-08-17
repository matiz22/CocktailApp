package pl.matiz22.cocktailapp.cocktails.di

import android.content.Context
import org.koin.dsl.module
import pl.matiz22.cocktails.data.local.repository.DrinksLocalRepositoryImpl
import pl.matiz22.cocktails.data.local.source.getCocktailsDb
import pl.matiz22.cocktails.domain.repository.local.DrinksLocalRepository

fun databaseModule(context: Context) = module {
    single {
        getCocktailsDb(context).cocktailDao()
    }
    single<DrinksLocalRepository> {
        DrinksLocalRepositoryImpl(get())
    }
}
