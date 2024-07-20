package pl.matiz22.cocktailapp.cocktails.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class DrinkWithIngredients (
    @Embedded val drinkEntity: DrinkEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "drinkId"
    )
    val ingredientsEntity: List<IngredientsEntity>
)
