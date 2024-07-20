package pl.matiz22.cocktailapp.cocktails.domain.repository.local

import pl.matiz22.cocktailapp.cocktails.domain.model.Drink
import pl.matiz22.cocktailapp.cocktails.domain.model.Drinks
import pl.matiz22.cocktailapp.root.domain.model.DataError
import pl.matiz22.cocktailapp.root.domain.model.Result

interface CocktailsLocalDbRepository {
    suspend fun getDrinks(): Result<Drinks, DataError>
    suspend fun saveDrink(drink: Drink): Result<Boolean, DataError>
}
