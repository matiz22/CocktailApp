package pl.matiz22.cocktailapp.cocktails.domain.repository

import pl.matiz22.cocktailapp.cocktails.domain.model.Drink
import pl.matiz22.cocktailapp.root.domain.DataError
import pl.matiz22.cocktailapp.root.domain.Result

interface DrinksRepository {
    suspend fun getDrinksByName(query: String): Result<List<Drink>, DataError.Network>
    suspend fun getDrinksByFirstLetter(letter: Char): Result<List<Drink>, DataError.Network>
    suspend fun getDrinkById(id: String): Result<Drink, DataError.Network>
    suspend fun getRandomDrink(): Result<Drink, DataError.Network>
    suspend fun getDrinkByIngredient(ingredient: String): Result<List<Drink>, DataError>
}