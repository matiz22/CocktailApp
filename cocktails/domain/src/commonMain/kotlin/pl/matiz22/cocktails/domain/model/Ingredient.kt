package pl.matiz22.cocktails.domain.model

data class Ingredient(
    val name: String,
    val id: Int? = null,
) {
    constructor(name: String) : this(name, null)
}
