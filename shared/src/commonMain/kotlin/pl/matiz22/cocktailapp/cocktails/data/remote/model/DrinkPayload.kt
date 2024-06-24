package pl.matiz22.cocktailapp.cocktails.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import pl.matiz22.cocktailapp.cocktails.domain.model.Drink
import pl.matiz22.cocktailapp.cocktails.domain.model.Ingredient
import pl.matiz22.cocktailapp.cocktails.domain.model.IngredientsAndMeasures
import pl.matiz22.cocktailapp.cocktails.domain.model.Measure

@Serializable
data class DrinkPayload(
    val idDrink: String,
    val strDrink: String,
    val strDrinkAlternate: String?,
    val strTags: String?,
    val strVideo: String?,
    val strCategory: String,
    val strIBA: String?,
    val strAlcoholic: String,
    val strGlass: String,
    val strInstructions: String,
    val strInstructionsES: String?,
    val strInstructionsDE: String?,
    val strInstructionsFR: String?,
    val strInstructionsIT: String?,
    @SerialName("strInstructionsZH-HANS")
    val strInstructionsZHHANS: String?,
    @SerialName("strInstructionsZH-HANT")
    val strInstructionsZHHANT: String?,
    val strDrinkThumb: String,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strMeasure1: String?,
    val strMeasure2: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?,
    val strImageSource: String?,
    val strImageAttribution: String?,
    val strCreativeCommonsConfirmed: String,
    val dateModified: String?
) {
    fun toDrink(): Drink {
        val ingredients = listOfNotNull(
            strIngredient1,
            strIngredient2,
            strIngredient3,
            strIngredient4,
            strIngredient5,
            strIngredient6,
            strIngredient7,
            strIngredient8,
            strIngredient9,
            strIngredient10,
            strIngredient11,
            strIngredient12,
            strIngredient13,
            strIngredient14,
            strIngredient15
        ).map { Ingredient(it) }
        val measures = listOfNotNull(
            strMeasure1,
            strMeasure2,
            strMeasure3,
            strMeasure4,
            strMeasure5,
            strMeasure6,
            strMeasure7,
            strMeasure8,
            strMeasure9,
            strMeasure10,
            strMeasure11,
            strMeasure12,
            strMeasure13,
            strMeasure14,
            strMeasure15
        ).map { Measure(it) }
        return Drink(
            id = idDrink,
            name = strDrink,
            category = strCategory,
            alcoholic = strAlcoholic,
            glass = strGlass,
            instructions = strInstructions,
            image = strDrinkThumb,
            ingredientsAndMeasures = IngredientsAndMeasures(
                values = ingredients.zip(measures).toMap()
            )
        )
    }
}