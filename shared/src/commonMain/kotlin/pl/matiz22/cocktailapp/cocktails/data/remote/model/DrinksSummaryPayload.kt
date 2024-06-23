package pl.matiz22.cocktailapp.cocktails.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DrinksSummaryPayload(
    @SerialName("drinks")
    val drinksSummary: List<DrinkSummaryPayload>
)