package pl.matiz22.cocktailapp.cocktails.di

import android.content.Context
import org.koin.dsl.module
import pl.matiz22.cocktailapp.cocktails.data.local.repository.CocktailsLocalDbRepositoryImpl
import pl.matiz22.cocktailapp.cocktails.data.local.source.getCocktailsDb
import pl.matiz22.cocktailapp.cocktails.domain.repository.local.CocktailsLocalDbRepository

fun databaseModule(context: Context) = module {
    single {
        getCocktailsDb(context).cocktailDao()
    }
    single<CocktailsLocalDbRepository> {
        CocktailsLocalDbRepositoryImpl(get())
    }
}
