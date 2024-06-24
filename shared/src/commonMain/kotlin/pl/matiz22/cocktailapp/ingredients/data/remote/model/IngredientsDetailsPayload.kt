package pl.matiz22.cocktailapp.ingredients.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientsDetailsPayload(
    @SerialName("ingredients")
    val ingredients: List<IngredientDetailsPayload>
)