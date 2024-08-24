package pl.matiz22.cocktails.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientsDetailsPayload(
    @SerialName("ingredients")
    val ingredients: List<IngredientDetailsPayload>,
)
