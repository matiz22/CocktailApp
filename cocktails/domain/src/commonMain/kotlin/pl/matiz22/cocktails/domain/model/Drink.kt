package pl.matiz22.cocktails.domain.model

data class Drink(
    val id: String,
    val name: String,
    val category: String,
    val alcoholic: String,
    val glass: String,
    val instructions: String,
    val image: String,
    val ingredientsAndMeasures: IngredientsAndMeasures,
    val liked: Boolean = false,
) {
    constructor(
        id: String,
        name: String,
        category: String,
        alcoholic: String,
        glass: String,
        instructions: String,
        image: String,
        ingredientsAndMeasures: IngredientsAndMeasures,
    ) : this(
        id = id,
        name = name,
        category = category,
        alcoholic = alcoholic,
        glass = glass,
        instructions = instructions,
        image = image,
        ingredientsAndMeasures = ingredientsAndMeasures,
        liked = false,
    )
}
