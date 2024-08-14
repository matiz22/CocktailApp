package pl.matiz22.cocktails.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Drinks")
data class DrinkEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val category: String,
    val alcoholic: String,
    val glass: String,
    val instructions: String,
    val image: String,
    val liked: Boolean
)
