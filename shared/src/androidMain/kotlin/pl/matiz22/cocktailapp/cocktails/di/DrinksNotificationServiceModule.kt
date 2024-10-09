package pl.matiz22.cocktailapp.cocktails.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.matiz22.cocktails.data.local.services.DrinksNotificationServiceImpl
import pl.matiz22.cocktails.domain.services.DrinksNotificationService

fun drinksNotificationServiceModule(
    mainActivity: Class<*>,
) = module {
    single<DrinksNotificationService> {
        DrinksNotificationServiceImpl(
            context = androidContext(),
            drinksRepository = get(),
            intentActivity = mainActivity,
        )
    }
}
