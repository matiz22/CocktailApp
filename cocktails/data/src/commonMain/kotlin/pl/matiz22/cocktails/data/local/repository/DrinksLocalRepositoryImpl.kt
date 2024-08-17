package pl.matiz22.cocktails.data.local.repository

import pl.matiz22.cocktails.data.local.dao.CocktailDao
import pl.matiz22.cocktails.data.local.model.DrinkWithIngredients
import pl.matiz22.cocktails.domain.model.Drink
import pl.matiz22.cocktails.domain.model.Drinks
import pl.matiz22.cocktails.domain.model.Ingredient
import pl.matiz22.cocktails.domain.model.IngredientsAndMeasures
import pl.matiz22.cocktails.domain.model.Measure
import pl.matiz22.cocktails.domain.repository.local.DrinksLocalRepository
import pl.matiz22.core.domain.model.DataError
import pl.matiz22.core.domain.model.Result


class DrinksLocalRepositoryImpl(
    private val cocktailDao: CocktailDao
) : DrinksLocalRepository {
    override suspend fun getDrinks(): Result<Drinks, DataError.Local> {
        return try {
            val drinks = cocktailDao.getDrinks()
            Result.Success(drinks.toDomain())
        } catch (e: Exception) {
            Result.Error(DataError.Local.DATABASE_ERROR)
        }
    }

    override suspend fun getDrink(drinkId: String): Result<Drink, DataError.Local> {
        return try {
            when (val drink = cocktailDao.getDrink(drinkId)) {
                null -> {
                    Result.Error(DataError.Local.NOT_FOUND)
                }

                else -> {
                    Result.Success(drink.toDomain())
                }
            }
        } catch (e: Exception) {
            Result.Error(DataError.Local.DATABASE_ERROR)
        }
    }

    override suspend fun saveDrink(drink: Drink): Result<Boolean, DataError.Local> {
        return try {
            cocktailDao.upsertDrinkWithIngredients(drink)
            Result.Success(true)
        } catch (e: Exception) {
            Result.Error(DataError.Local.DATABASE_ERROR)
        }
    }

    override suspend fun getFavDrinks(): Result<Drinks, DataError.Local> {
        return try {
            val favDrinks = cocktailDao.getFavDrinks()
            Result.Success(favDrinks.toDomain())
        } catch (e: Exception) {
            Result.Error(DataError.Local.DATABASE_ERROR)
        }
    }

    override suspend fun getRecentDrinks(): Result<Drinks, DataError.Local> {
        return try {
            val recentDrinks = cocktailDao.getRecentDrinks()
            Result.Success(recentDrinks.toDomain())
        } catch (e: Exception) {
            Result.Error(DataError.Local.DATABASE_ERROR)
        }
    }

    private fun List<DrinkWithIngredients>.toDomain(): Drinks {
        return Drinks(
            drinks = this.map { drinkWithIngredients ->
                drinkWithIngredients.toDomain()
            }
        )
    }

    private fun DrinkWithIngredients.toDomain(): Drink {
        return Drink(
            id = this.drinkEntity.id,
            name = this.drinkEntity.name,
            category = this.drinkEntity.category,
            instructions = this.drinkEntity.instructions,
            alcoholic = this.drinkEntity.alcoholic,
            glass = this.drinkEntity.glass,
            image = this.drinkEntity.image,
            ingredientsAndMeasures = IngredientsAndMeasures(
                this.ingredientsEntity.associate { ingredientsEntity ->
                    Ingredient(
                        id = ingredientsEntity.id,
                        name = ingredientsEntity.ingredientName
                    ) to Measure(
                        ingredientsEntity.ingredientName
                    )
                }
            ),
            liked = this.drinkEntity.liked
        )
    }
}
