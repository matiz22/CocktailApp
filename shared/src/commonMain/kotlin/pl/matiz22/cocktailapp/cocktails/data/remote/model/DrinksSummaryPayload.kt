package pl.matiz22.cocktailapp.cocktails.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import pl.matiz22.cocktailapp.cocktails.domain.model.DrinksSummary

@Serializable
data class DrinksSummaryPayload(
    @SerialName("drinks")
    val drinksSummary: List<DrinkSummaryPayload>?
) {
    fun toDrinksSummary() = DrinksSummary(
        drinksSummary = drinksSummary?.map { it.toDrinkSummary() } ?: emptyList()
    )
}