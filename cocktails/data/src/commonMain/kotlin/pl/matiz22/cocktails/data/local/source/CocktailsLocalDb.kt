package pl.matiz22.cocktails.data.local.source

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.matiz22.cocktails.data.local.dao.CocktailDao
import pl.matiz22.cocktails.data.local.model.DrinkEntity
import pl.matiz22.cocktails.data.local.model.IngredientsEntity

@Database(entities = [DrinkEntity::class, IngredientsEntity::class], version = 1)
abstract class CocktailsLocalDb : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}
