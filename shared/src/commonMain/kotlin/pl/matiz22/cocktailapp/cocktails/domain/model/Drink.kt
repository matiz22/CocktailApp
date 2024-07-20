package pl.matiz22.cocktailapp.cocktails.domain.model

data class Drink(
    val id: String,
    val name: String,
    val category: String,
    val alcoholic: String,
    val glass: String,
    val instructions: String,
    val image: String,
    val ingredientsAndMeasures: IngredientsAndMeasures,
    val liked: Boolean = false
)
