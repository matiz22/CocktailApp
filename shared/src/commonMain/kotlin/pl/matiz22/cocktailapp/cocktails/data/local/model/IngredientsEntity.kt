package pl.matiz22.cocktailapp.cocktails.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ingredients")
data class IngredientsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val drinkId: String,
    val ingredientName: String,
    val measure: String
)
