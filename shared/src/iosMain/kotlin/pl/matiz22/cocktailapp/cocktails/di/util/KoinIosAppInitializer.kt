package pl.matiz22.cocktailapp.cocktails.di.util

import org.koin.core.context.startKoin
import pl.matiz22.cocktailapp.cocktails.di.cocktailsDataModule
import pl.matiz22.cocktailapp.cocktails.di.cocktailsLocalDataModule
import pl.matiz22.cocktailapp.cocktails.di.databaseModule

fun koinIosAppInitializer() {
    startKoin {
        modules(
            listOf(
                cocktailsDataModule(),
                cocktailsLocalDataModule(),
                databaseModule(),
            ),
        )
    }
}
