package pl.matiz22.cocktails.data.local.source

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getCocktailsDb(): CocktailsLocalDb {
    val dbFile = NSHomeDirectory() + "/cocktails.db"
    return Room.databaseBuilder<CocktailsLocalDb>(
        name = dbFile,
        factory = { CocktailsLocalDb::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver()).build()
}
