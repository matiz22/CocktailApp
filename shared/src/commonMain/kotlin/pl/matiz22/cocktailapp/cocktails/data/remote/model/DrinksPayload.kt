package pl.matiz22.cocktailapp.cocktails.data.remote.model


import kotlinx.serialization.Serializable
import pl.matiz22.cocktailapp.cocktails.domain.model.Drinks

@Serializable
data class DrinksPayload(
    val drinks: List<DrinkPayload>
){
    fun toDrinks() = Drinks(
        drinks = drinks.map { it.toDrink() }
    )
}