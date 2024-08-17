package pl.matiz22.cocktails.data.local.source

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getCocktailsDb(context: Context): CocktailsLocalDb {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("cocktails.db")
    return Room.databaseBuilder<CocktailsLocalDb>(
        context = appContext,
        name = dbFile.absolutePath
    ).setDriver(BundledSQLiteDriver()).build()
}
