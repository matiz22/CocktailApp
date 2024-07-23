package pl.matiz22.cocktailapp.cocktails.di

import android.content.Context
import org.koin.dsl.module
import pl.matiz22.cocktailapp.cocktails.data.local.repository.CocktailsLocalDbRepositoryImpl
import pl.matiz22.cocktailapp.cocktails.data.local.source.getCocktailsDb
import pl.matiz22.cocktailapp.cocktails.domain.repository.local.DrinksLocalRepository

fun databaseModule(context: Context) = module {
    single {
        getCocktailsDb(context).cocktailDao()
    }
    single<DrinksLocalRepository> {
        CocktailsLocalDbRepositoryImpl(get())
    }
}
