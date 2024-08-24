package pl.matiz22.cocktails.data.local.source

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import pl.matiz22.cocktails.data.local.dao.CocktailDao
import pl.matiz22.cocktails.data.local.model.DrinkEntity
import pl.matiz22.cocktails.data.local.model.IngredientsEntity

@Database(entities = [DrinkEntity::class, IngredientsEntity::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class CocktailsLocalDb : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<CocktailsLocalDb>
