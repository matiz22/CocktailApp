package pl.matiz22.cocktails.data.remote.repository

import pl.matiz22.cocktails.data.remote.model.DrinksPayload
import pl.matiz22.cocktails.data.remote.source.CocktailsDbApi
import pl.matiz22.cocktails.domain.model.Drink
import pl.matiz22.cocktails.domain.model.Drinks
import pl.matiz22.cocktails.domain.model.DrinksSummary
import pl.matiz22.cocktails.domain.repository.remote.DrinksRepository
import pl.matiz22.core.domain.model.DataError
import pl.matiz22.core.domain.model.DataOrError
import pl.matiz22.core.domain.model.Result

class DrinksRepositoryImpl(
    private val cocktailsDbApi: CocktailsDbApi,
) : DrinksRepository {
    override suspend fun getDrinksByName(query: String): DataOrError<Drinks, DataError.Network> {
        val networkResult = cocktailsDbApi.getDrinkByName(query)
        return dataModelDrinksToDomain(networkResult)
    }

    override suspend fun getDrinksByFirstLetter(letter: Char): DataOrError<Drinks, DataError.Network> {
        val networkResult = cocktailsDbApi.getDrinksByFirstLetter(letter)
        return dataModelDrinksToDomain(networkResult)
    }

    override suspend fun getDrinkById(id: String): DataOrError<Drink, DataError.Network> {
        val networkResult = cocktailsDbApi.getDrinkById(id)
        return dataModelDrinkToDomain(networkResult)
    }

    override suspend fun getRandomDrink(): DataOrError<Drink, DataError.Network> {
        val networkResult = cocktailsDbApi.getRandomDrink()
        return dataModelDrinkToDomain(networkResult)
    }

    override suspend fun getDrinksByIngredient(ingredient: String): DataOrError<DrinksSummary, DataError.Network> =
        when (val networkResult = cocktailsDbApi.getDrinkByIngredient(ingredient)) {
            is Result.Success -> DataOrError(data = networkResult.data.toDrinksSummary())
            is Result.Error -> DataOrError(error = networkResult.error)
        }

    private fun dataModelDrinksToDomain(networkResult: Result<DrinksPayload, DataError.Network>): DataOrError<Drinks, DataError.Network> =
        when (networkResult) {
            is Result.Success -> DataOrError(data = networkResult.data.toDrinks())
            is Result.Error -> DataOrError(error = networkResult.error)
        }

    private fun dataModelDrinkToDomain(networkResult: Result<DrinksPayload, DataError.Network>): DataOrError<Drink, DataError.Network> =
        when (networkResult) {
            is Result.Success -> {
                when {
                    networkResult.data.drinks.isNullOrEmpty() -> {
                        DataOrError(error = DataError.Network.NOT_FOUND)
                    }

                    else -> {
                        DataOrError(
                            data = networkResult.data
                                .toDrinks()
                                .drinks
                                .first(),
                        )
                    }
                }
            }

            is Result.Error -> DataOrError(error = networkResult.error)
        }
}
