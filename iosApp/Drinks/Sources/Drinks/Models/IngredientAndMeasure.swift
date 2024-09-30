import Shared

public struct IngredientAndMeasure: Identifiable {
	public let id: UUID = .init()
	public let ingredient: Ingredient
	public let measure: Measure
}
