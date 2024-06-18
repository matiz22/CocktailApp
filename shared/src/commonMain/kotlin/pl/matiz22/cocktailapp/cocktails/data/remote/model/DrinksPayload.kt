package pl.matiz22.cocktailapp.cocktails.data.remote.model


import kotlinx.serialization.Serializable

@Serializable
data class DrinksPayload(
    val drinks: List<DrinkPayload>
)