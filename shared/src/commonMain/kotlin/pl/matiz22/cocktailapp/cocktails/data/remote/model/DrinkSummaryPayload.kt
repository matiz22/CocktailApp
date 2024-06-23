package pl.matiz22.cocktailapp.cocktails.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DrinkSummaryPayload(
    @SerialName("strDrink")
    val strDrink: String,
    @SerialName("strDrinkThumb")
    val strDrinkThumb: String,
    @SerialName("idDrink")
    val idDrink: String
)