import Shared
import SwiftUI

public struct IngredientsAndMeasuresView: View {
	private let ingredientsAndMeasures: [IngredientAndMeasure]

	public init(ingredientsAndMeasures: IngredientsAndMeasures) {
		self.ingredientsAndMeasures = ingredientsAndMeasures.toList()
	}

	public var body: some View {
		VStack(alignment: .leading, spacing: 6) {
			Text(String(localized: "ingredientsAndMeasureHeader")).font(.headline)
			Grid(verticalSpacing: 0) {
				ForEach(ingredientsAndMeasures) { ingredientAndMeasure in
					GridRow {
						HStack {
							Text(ingredientAndMeasure.ingredient.name).padding(4)
							Spacer()
						}.border(.black)
						HStack {
							Text(ingredientAndMeasure.measure.value).padding(4)
							Spacer()
						}.border(.black)
					}
				}
			}.border(.black)
		}
	}
}
