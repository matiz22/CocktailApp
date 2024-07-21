package pl.matiz22.cocktailapp.cocktails.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import pl.matiz22.cocktailapp.cocktails.data.local.model.DrinkEntity
import pl.matiz22.cocktailapp.cocktails.data.local.model.DrinkWithIngredients
import pl.matiz22.cocktailapp.cocktails.data.local.model.IngredientsEntity
import pl.matiz22.cocktailapp.cocktails.domain.model.Drink

@Dao
interface CocktailDao {
    @Upsert
    suspend fun upsertDrinkEntity(drink: DrinkEntity)

    @Upsert
    suspend fun upsertIngredientsEntity(ingredientsEntity: List<IngredientsEntity>)

    @Transaction
    suspend fun upsertDrinkWithIngredients(drink: Drink) {
        val parent = upsertDrinkEntity(
            DrinkEntity(
                id = drink.id,
                name = drink.name,
                category = drink.category,
                alcoholic = drink.alcoholic,
                glass = drink.glass,
                instructions = drink.instructions,
                image = drink.image,
                liked = drink.liked
            )
        )
        upsertIngredientsEntity(drink.ingredientsAndMeasures.values.map { ingredient ->
            IngredientsEntity(
                id = ingredient.key.id ?: 0,
                drinkId = drink.id,
                ingredientName = ingredient.key.name,
                measure = ingredient.value.value
            )
        })
    }

    @Query("SELECT * FROM Drinks")
    suspend fun getDrinks(): List<DrinkWithIngredients>

    @Query("SELECT * FROM Drinks WHERE liked == TRUE")
    suspend fun getFavDrinks(): List<DrinkWithIngredients>
}
