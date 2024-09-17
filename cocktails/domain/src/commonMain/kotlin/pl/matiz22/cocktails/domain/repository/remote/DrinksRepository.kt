package pl.matiz22.cocktails.domain.repository.remote

import pl.matiz22.cocktails.domain.model.Drink
import pl.matiz22.cocktails.domain.model.Drinks
import pl.matiz22.cocktails.domain.model.DrinksSummary
import pl.matiz22.core.domain.model.DataError
import pl.matiz22.core.domain.model.DataOrError

interface DrinksRepository {
    suspend fun getDrinksByName(query: String): DataOrError<Drinks, DataError.Network>

    suspend fun getDrinksByFirstLetter(letter: Char): DataOrError<Drinks, DataError.Network>

    suspend fun getDrinkById(id: String): DataOrError<Drink, DataError.Network>

    suspend fun getRandomDrink(): DataOrError<Drink, DataError.Network>

    suspend fun getDrinksByIngredient(ingredient: String): DataOrError<DrinksSummary, DataError.Network>
}
