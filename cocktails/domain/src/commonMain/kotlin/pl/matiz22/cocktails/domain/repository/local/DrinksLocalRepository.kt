package pl.matiz22.cocktails.domain.repository.local

import pl.matiz22.cocktailapp.cocktails.domain.model.Drink
import pl.matiz22.cocktailapp.cocktails.domain.model.Drinks
import pl.matiz22.core.domain.model.Result
import pl.matiz22.core.domain.model.DataError


interface DrinksLocalRepository {
    suspend fun getDrinks(): Result<Drinks, DataError.Local>
    suspend fun getDrink(drinkId: String): Result<Drink, DataError.Local>
    suspend fun saveDrink(drink: Drink): Result<Boolean, DataError.Local>
    suspend fun getFavDrinks(): Result<Drinks, DataError.Local>
    suspend fun getRecentDrinks(): Result<Drinks, DataError.Local>
}
