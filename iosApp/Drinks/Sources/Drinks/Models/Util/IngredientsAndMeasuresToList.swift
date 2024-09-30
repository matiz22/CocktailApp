import Shared

extension IngredientsAndMeasures {
	func toList() -> [IngredientAndMeasure] {
		values.map { ingredient, measure in
			IngredientAndMeasure(ingredient: ingredient, measure: measure)
		}
	}
}
