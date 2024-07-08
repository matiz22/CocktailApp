package pl.matiz22.cocktailapp.core.di

import org.koin.dsl.module
import pl.matiz22.cocktailapp.core.data.repository.NavHeadersRepositoryImpl
import pl.matiz22.cocktailapp.core.domain.repository.NavHeadersRepository

fun navHeadersModule() = module {
    single<NavHeadersRepository> {
        NavHeadersRepositoryImpl()
    }
}
