package pl.matiz22.cocktailapp.cocktails.data.local.repository

import pl.matiz22.cocktailapp.cocktails.data.local.dao.CocktailDao
import pl.matiz22.cocktailapp.cocktails.data.local.model.DrinkWithIngredients
import pl.matiz22.cocktailapp.cocktails.data.local.source.CocktailsLocalDb
import pl.matiz22.cocktailapp.cocktails.domain.model.Drink
import pl.matiz22.cocktailapp.cocktails.domain.model.Drinks
import pl.matiz22.cocktailapp.cocktails.domain.model.Ingredient
import pl.matiz22.cocktailapp.cocktails.domain.model.IngredientsAndMeasures
import pl.matiz22.cocktailapp.cocktails.domain.model.Measure
import pl.matiz22.cocktailapp.cocktails.domain.repository.local.CocktailsLocalDbRepository
import pl.matiz22.cocktailapp.root.domain.model.DataError
import pl.matiz22.cocktailapp.root.domain.model.Result

class CocktailsLocalDbRepositoryImpl(
    private val cocktailDao: CocktailDao
) : CocktailsLocalDbRepository {
    override suspend fun getDrinks(): Result<Drinks, DataError> {
        return try {
            val drinks = cocktailDao.getDrinks()
            Result.Success(drinks.toDomain())
        } catch (e: Exception) {
            Result.Error(DataError.Local.DATABASE_ERROR)
        }
    }

    override suspend fun saveDrink(drink: Drink): Result<Boolean, DataError> {
        return try {
            cocktailDao.upsertDrinkWithIngredients(drink)
            Result.Success(true)
        } catch (e: Exception) {
            Result.Error(DataError.Local.DATABASE_ERROR)
        }
    }

    override suspend fun getFavDrinks(): Result<Drinks, DataError> {
        return try {
            val favDrinks = cocktailDao.getFavDrinks()
            Result.Success(favDrinks.toDomain())
        } catch (e: Exception) {
            Result.Error(DataError.Local.DATABASE_ERROR)
        }
    }

    private fun List<DrinkWithIngredients>.toDomain(): Drinks {
        return Drinks(
            drinks = this.map { drinkWithIngredients ->
                Drink(
                    id = drinkWithIngredients.drinkEntity.id,
                    name = drinkWithIngredients.drinkEntity.name,
                    category = drinkWithIngredients.drinkEntity.category,
                    instructions = drinkWithIngredients.drinkEntity.instructions,
                    alcoholic = drinkWithIngredients.drinkEntity.alcoholic,
                    glass = drinkWithIngredients.drinkEntity.glass,
                    image = drinkWithIngredients.drinkEntity.image,
                    ingredientsAndMeasures = IngredientsAndMeasures(
                        drinkWithIngredients.ingredientsEntity.associate { ingredientsEntity ->
                            Ingredient(
                                id = ingredientsEntity.id,
                                name = ingredientsEntity.ingredientName
                            ) to Measure(
                                ingredientsEntity.ingredientName
                            )
                        }
                    ),
                    liked = drinkWithIngredients.drinkEntity.liked
                )
            }
        )
    }
}
