import Core
import Foundation
import Shared
import SwiftUI

public struct DrinkHorizontalPosition: View {
	private let drink: Drink
	private let withLike: Bool

	public init(drink: Drink, withLike: Bool = false) {
		self.drink = drink
		self.withLike = withLike
	}

	public var body: some View {
		NavigationLink(value: CoreRoutes.drinkDetails(drinkId: drink.id)) {
			HStack(spacing: 12) {
				AsyncImage(url: URL(string: drink.image)) { state in
					switch state {
					case let .success(image):
						image
							.resizable()
							.scaledToFit()
							.frame(width: 100, height: 100)
							.cornerRadius(8)
					default:
						Image("drink_icon", bundle: .module)
							.resizable()
							.scaledToFit()
							.frame(width: 100, height: 100)
							.cornerRadius(8)
					}
				}
				VStack(alignment: .leading, spacing: 12) {
					Text(drink.name).font(.heading1).padding(-6).fixedSize(horizontal: false, vertical: true)
					Text(drink.category).font(.paragraphLarge).foregroundStyle(Color("FontLight", bundle: .CoreBundle)).padding(-6)
				}
				Spacer()
				if withLike {
					Image(drink.liked ? "heartFill" : "heartOutline", bundle: .CoreBundle)
						.tint(Color(drink.liked ? "BrandAccent" : "OnContainer", bundle: .CoreBundle))
				}

			}.frame(
				maxWidth: .infinity,
				maxHeight: .infinity
			).padding(14).background(Color("Container", bundle: .CoreBundle)).cornerRadius(8)
		}.buttonStyle(.plain)
	}
}

#Preview {
	let mojito = Drink(
		id: "12345",
		name: "Mojito",
		category: "Cocktail",
		alcoholic: "Alcoholic",
		glass: "Highball glass",
		instructions: """
		Muddle mint leaves with sugar and lime juice. Add a splash of soda water and fill the glass with cracked ice. Pour the rum and top with soda water. Garnish and serve with straw.
		""",
		image: "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
		ingredientsAndMeasures: IngredientsAndMeasures(
			values: [
				Ingredient(name: "White rum"): Measure(value: "2 oz"),
				Ingredient(name: "Sugar"): Measure(value: "2 tsp"),
				Ingredient(name: "Lime juice"): Measure(value: "1 oz"),
				Ingredient(name: "Soda water"): Measure(value: "To top"),
				Ingredient(name: "Mint"): Measure(value: "4-5 leaves"),
			]
		)
	)
	return DrinkHorizontalPosition(drink: mojito)
}
