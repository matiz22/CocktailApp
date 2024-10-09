package pl.matiz22.cocktailapp.cocktails.di

import org.koin.dsl.module
import pl.matiz22.cocktails.data.local.services.DrinksNotificationServiceImpl
import pl.matiz22.cocktails.domain.services.DrinksNotificationService

fun drinksNotificationServiceModule() = module {
    single<DrinksNotificationService> { DrinksNotificationServiceImpl(get()) }
}
