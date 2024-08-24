package pl.matiz22.cocktails.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientDetailsPayload(
    @SerialName("idIngredient")
    val idIngredient: String,
    @SerialName("strIngredient")
    val strIngredient: String,
    @SerialName("strDescription")
    val strDescription: String,
    @SerialName("strType")
    val strType: String,
    @SerialName("strAlcohol")
    val strAlcohol: String,
    @SerialName("strABV")
    val strABV: String?,
)
