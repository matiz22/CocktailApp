package pl.matiz22.cocktailapp.android

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import pl.matiz22.cocktailapp.android.drinks.di.drinksViewModelsModule
import pl.matiz22.cocktailapp.android.favourites.di.favViewModelModule
import pl.matiz22.cocktailapp.android.home.di.homeViewModelModule
import pl.matiz22.cocktailapp.android.search.di.searchViewModelsModule
import pl.matiz22.cocktailapp.cocktails.di.cocktailsViewModelsModule
import pl.matiz22.cocktailapp.cocktails.di.databaseModule
import pl.matiz22.cocktailapp.cocktails.di.drinksNotificationServiceModule
import pl.matiz22.cocktails.domain.service.util.NotificationConstants

class CocktailApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        notificationChannels()
        startKoin {
            androidContext(this@CocktailApplication)
            androidLogger()
            modules(
                listOf(
                    cocktailsViewModelsModule(),
                    searchViewModelsModule(),
                    drinksViewModelsModule(),
                    databaseModule(applicationContext),
                    favViewModelModule(),
                    homeViewModelModule(),
                    drinksNotificationServiceModule(MainActivity::class.java),
                ),
            )
        }
    }

    private fun notificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val randomDrinkChannel = NotificationChannel(
                NotificationConstants.RANDOM_DRINK_ID,
                NotificationConstants.RANDOM_DRINK_NAME,
                NotificationManager.IMPORTANCE_DEFAULT,
            )
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(randomDrinkChannel)
        }
    }
}
