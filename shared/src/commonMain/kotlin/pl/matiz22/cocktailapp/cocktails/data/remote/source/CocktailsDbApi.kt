package pl.matiz22.cocktailapp.cocktails.data.remote.source

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess
import pl.matiz22.cocktailapp.cocktails.data.remote.model.DrinksPayload
import pl.matiz22.cocktailapp.cocktails.data.remote.model.DrinksSummaryPayload
import pl.matiz22.cocktailapp.root.data.util.provideDataErrorNetworkForException
import pl.matiz22.cocktailapp.root.data.util.provideDataErrorNetworkForHttpCode
import pl.matiz22.core.domain.model.Result
import pl.matiz22.core.domain.model.DataError

class CocktailsDbApi(private val httpClient: HttpClient) {
    suspend fun getDrinkByName(query: String): Result<DrinksPayload, DataError.Network> {
        return try {
            val response = httpClient.get("search.php?s=$query")
            if (response.status.isSuccess()) {
                Result.Success(response.body())
            } else {
                Result.Error(provideDataErrorNetworkForHttpCode(response.status.value))
            }
        } catch (e: Exception) {
            Result.Error(provideDataErrorNetworkForException(e))
        }
    }

    suspend fun getDrinksByFirstLetter(letter: Char): Result<DrinksPayload, DataError.Network> {
        return try {
            val response = httpClient.get("search.php?f=$letter")
            if (response.status.isSuccess()) {
                Result.Success(response.body())
            } else {
                Result.Error(provideDataErrorNetworkForHttpCode(response.status.value))
            }
        } catch (e: Exception) {
            Result.Error(provideDataErrorNetworkForException(e))
        }
    }

    suspend fun getDrinkById(id: String): Result<DrinksPayload, DataError.Network> {
        return try {
            val response = httpClient.get("lookup.php?i=$id")
            if (response.status.isSuccess()) {
                Result.Success(response.body())
            } else {
                Result.Error(provideDataErrorNetworkForHttpCode(response.status.value))
            }
        } catch (e: Exception) {
            Result.Error(provideDataErrorNetworkForException(e))
        }
    }

    suspend fun getRandomDrink(): Result<DrinksPayload, DataError.Network> {
        return try {
            val response = httpClient.get("random.php")
            if (response.status.isSuccess()) {
                Result.Success(response.body())
            } else {
                Result.Error(provideDataErrorNetworkForHttpCode(response.status.value))
            }
        } catch (e: Exception) {
            Result.Error(provideDataErrorNetworkForException(e))
        }
    }

    suspend fun getDrinkByIngredient(ingredient: String): Result<DrinksSummaryPayload, DataError.Network> {
        return try {
            val response = httpClient.get("filter.php?i=${ingredient}")
            if (response.status.isSuccess()) {
                Result.Success(response.body())
            } else {
                Result.Error(provideDataErrorNetworkForHttpCode(response.status.value))
            }
        } catch (e: Exception) {
            Result.Error(provideDataErrorNetworkForException(e))
        }
    }
}