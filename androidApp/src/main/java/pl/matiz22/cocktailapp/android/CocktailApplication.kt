package pl.matiz22.cocktailapp.android

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import pl.matiz22.cocktailapp.android.drinks.di.drinksViewModelsModule
import pl.matiz22.cocktailapp.android.favourites.di.favViewModelModule
import pl.matiz22.cocktailapp.android.home.di.homeViewModelModule
import pl.matiz22.cocktailapp.android.search.di.searchViewModelsModule
import pl.matiz22.cocktailapp.cocktails.di.cocktailsViewModelsModule
import pl.matiz22.cocktailapp.cocktails.di.databaseModule

class CocktailApplication : Application() {
    override fun onCreate() {
        super.onCreate()
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
                    homeViewModelModule()
                )
            )
        }
    }
}
