package pl.matiz22.cocktailapp.cocktails.data.remote.repository

import pl.matiz22.cocktailapp.cocktails.data.remote.model.DrinksPayload
import pl.matiz22.cocktailapp.cocktails.data.remote.source.CocktailsDbApi
import pl.matiz22.cocktailapp.cocktails.domain.model.Drink
import pl.matiz22.cocktailapp.cocktails.domain.model.Drinks
import pl.matiz22.cocktailapp.cocktails.domain.model.DrinksSummary
import pl.matiz22.cocktailapp.cocktails.domain.repository.remote.DrinksRepository
import pl.matiz22.cocktailapp.root.domain.model.DataError
import pl.matiz22.cocktailapp.root.domain.model.Result

class DrinksRepositoryImpl(private val cocktailsDbApi: CocktailsDbApi) : DrinksRepository {
    override suspend fun getDrinksByName(query: String): Result<Drinks, DataError.Network> {
        val networkResult = cocktailsDbApi.getDrinkByName(query)
        return dataModelDrinksToDomain(networkResult)
    }

    override suspend fun getDrinksByFirstLetter(letter: Char): Result<Drinks, DataError.Network> {
        val networkResult = cocktailsDbApi.getDrinksByFirstLetter(letter)
        return dataModelDrinksToDomain(networkResult)
    }

    override suspend fun getDrinkById(id: String): Result<Drink, DataError.Network> {
        val networkResult = cocktailsDbApi.getDrinkById(id)
        return dataModelDrinkToDomain(networkResult)
    }

    override suspend fun getRandomDrink(): Result<Drink, DataError.Network> {
        val networkResult = cocktailsDbApi.getRandomDrink()
        return dataModelDrinkToDomain(networkResult)
    }

    override suspend fun getDrinksByIngredient(ingredient: String): Result<DrinksSummary, DataError.Network> {
        return when (val networkResult = cocktailsDbApi.getDrinkByIngredient(ingredient)) {
            is Result.Success -> Result.Success(networkResult.data.toDrinksSummary())
            is Result.Error -> Result.Error(networkResult.error)
        }
    }

    private fun dataModelDrinksToDomain(networkResult: Result<DrinksPayload, DataError.Network>): Result<Drinks, DataError.Network> {
        return when (networkResult) {
            is Result.Success -> Result.Success(networkResult.data.toDrinks())
            is Result.Error -> Result.Error(networkResult.error)
        }
    }

    private fun dataModelDrinkToDomain(networkResult: Result<DrinksPayload, DataError.Network>): Result<Drink, DataError.Network> {
        return when (networkResult) {
            is Result.Success -> {
                when {
                    networkResult.data.drinks.isNullOrEmpty() -> {
                        Result.Error(DataError.Network.NOT_FOUND)
                    }

                    else -> {
                        Result.Success(networkResult.data.toDrinks().drinks.first())
                    }
                }

            }

            is Result.Error -> Result.Error(networkResult.error)
        }
    }
}