import Shared

extension Drink {
	func makeCopy(
		id: String? = nil,
		name: String? = nil,
		category: String? = nil,
		alcoholic: String? = nil,
		glass: String? = nil,
		instructions: String? = nil,
		image: String? = nil,
		ingredientsAndMeasures: IngredientsAndMeasures? = nil,
		liked: Bool? = nil
	) -> Drink {
		return Drink(
			id: id ?? self.id,
			name: name ?? self.name,
			category: category ?? self.category,
			alcoholic: alcoholic ?? self.alcoholic,
			glass: glass ?? self.glass,
			instructions: instructions ?? self.instructions,
			image: image ?? self.image,
			ingredientsAndMeasures: ingredientsAndMeasures ?? self.ingredientsAndMeasures,
			liked: liked ?? self.liked
		)
	}
}
