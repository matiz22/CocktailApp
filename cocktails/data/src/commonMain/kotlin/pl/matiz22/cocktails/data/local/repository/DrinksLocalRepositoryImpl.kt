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
import pl.matiz22.core.domain.model.DataOrError

class DrinksLocalRepositoryImpl(
    private val cocktailDao: CocktailDao,
) : DrinksLocalRepository {
    override suspend fun getDrinks(): DataOrError<Drinks, DataError.Local> =
        try {
            val drinks = cocktailDao.getDrinks()
            DataOrError(data = drinks.toDomain())
        } catch (e: Exception) {
            DataOrError(error = DataError.Local.DATABASE_ERROR)
        }

    override suspend fun getDrink(drinkId: String): DataOrError<Drink, DataError.Local> =
        try {
            when (val drink = cocktailDao.getDrink(drinkId)) {
                null -> {
                    DataOrError(error = DataError.Local.NOT_FOUND)
                }

                else -> {
                    DataOrError(data = drink.toDomain())
                }
            }
        } catch (e: Exception) {
            DataOrError(error = DataError.Local.DATABASE_ERROR)
        }

    override suspend fun saveDrink(drink: Drink): DataOrError<Boolean, DataError.Local> =
        try {
            cocktailDao.upsertDrinkWithIngredients(drink)
            DataOrError(true)
        } catch (e: Exception) {
            DataOrError(error = DataError.Local.DATABASE_ERROR)
        }

    override suspend fun getFavDrinks(): DataOrError<Drinks, DataError.Local> =
        try {
            val favDrinks = cocktailDao.getFavDrinks()
            DataOrError(data = favDrinks.toDomain())
        } catch (e: Exception) {
            DataOrError(error = DataError.Local.DATABASE_ERROR)
        }

    override suspend fun getRecentDrinks(): DataOrError<Drinks, DataError.Local> =
        try {
            val recentDrinks = cocktailDao.getRecentDrinks()
            DataOrError(data = recentDrinks.toDomain())
        } catch (e: Exception) {
            DataOrError(error = DataError.Local.DATABASE_ERROR)
        }

    private fun List<DrinkWithIngredients>.toDomain(): Drinks =
        Drinks(
            drinks =
            this.map { drinkWithIngredients ->
                drinkWithIngredients.toDomain()
            },
        )

    private fun DrinkWithIngredients.toDomain(): Drink =
        Drink(
            id = this.drinkEntity.id,
            name = this.drinkEntity.name,
            category = this.drinkEntity.category,
            instructions = this.drinkEntity.instructions,
            alcoholic = this.drinkEntity.alcoholic,
            glass = this.drinkEntity.glass,
            image = this.drinkEntity.image,
            ingredientsAndMeasures =
            IngredientsAndMeasures(
                this.ingredientsEntity.associate { ingredientsEntity ->
                    Ingredient(
                        id = ingredientsEntity.id,
                        name = ingredientsEntity.ingredientName,
                    ) to
                        Measure(
                            ingredientsEntity.ingredientName,
                        )
                },
            ),
            liked = this.drinkEntity.liked,
        )
}
