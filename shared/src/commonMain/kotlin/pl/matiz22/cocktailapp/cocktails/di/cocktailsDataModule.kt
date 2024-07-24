package pl.matiz22.cocktailapp.cocktails.di

import org.koin.dsl.module
import pl.matiz22.cocktailapp.cocktails.data.remote.repository.DrinksRepositoryImpl
import pl.matiz22.cocktailapp.cocktails.data.remote.source.CocktailsDbApi
import pl.matiz22.cocktailapp.cocktails.data.remote.source.httpClient
import pl.matiz22.cocktailapp.cocktails.data.remote.util.defaultHttpClientConfig
import pl.matiz22.cocktailapp.cocktails.domain.repository.remote.DrinksRepository

fun cocktailsDataModule() = module {
    single {
        CocktailsDbApi(httpClient = httpClient(config = defaultHttpClientConfig))
    }
    single<DrinksRepository> {
        DrinksRepositoryImpl(get())
    }
}
