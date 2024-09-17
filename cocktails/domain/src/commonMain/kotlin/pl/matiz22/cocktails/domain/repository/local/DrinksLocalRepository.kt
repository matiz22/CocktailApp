package pl.matiz22.cocktails.domain.repository.local

import pl.matiz22.cocktails.domain.model.Drink
import pl.matiz22.cocktails.domain.model.Drinks
import pl.matiz22.core.domain.model.DataError
import pl.matiz22.core.domain.model.DataOrError

interface DrinksLocalRepository {
    suspend fun getDrinks(): DataOrError<Drinks, DataError.Local>

    suspend fun getDrink(drinkId: String): DataOrError<Drink, DataError.Local>

    suspend fun saveDrink(drink: Drink): DataOrError<Boolean, DataError.Local>

    suspend fun getFavDrinks(): DataOrError<Drinks, DataError.Local>

    suspend fun getRecentDrinks(): DataOrError<Drinks, DataError.Local>
}
