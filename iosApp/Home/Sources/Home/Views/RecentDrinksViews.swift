import Drinks
import Shared
import SwiftUI

public struct RecentDrinksViews: View {
	private let recentDrinks: Drinks

	public init(recentDrinks: Drinks) {
		self.recentDrinks = recentDrinks
	}

	public var body: some View {
		VStack(alignment: .leading, spacing: 0) {
			Text(String(localized: "recentDrinks", bundle: .HomeBundle)).font(.heading3).padding(EdgeInsets(top: 12, leading: 16, bottom: 2, trailing: 0))
			ScrollView(.horizontal, showsIndicators: false) {
				HStack {
					ForEach(recentDrinks.drinks, id: \.id) { drink in
						DrinkVerticalPosition(drink: drink)
					}
				}
			}.padding(EdgeInsets(top: 2, leading: 0, bottom: 8, trailing: 0))
			Spacer()
		}.frame(height: 250).background(Color("Container", bundle: .CoreBundle))
	}
}

#Preview {
	VStack {
		RecentDrinksViews(recentDrinks: Drinks(drinks: [Drink(
				id: UUID().uuidString,
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
			), Drink(
				id: UUID().uuidString,
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
			), Drink(
				id: UUID().uuidString,
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
			),
			Drink(
				id: UUID().uuidString,
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
			)]))
		RecentDrinksViews(recentDrinks: Drinks(drinks: [Drink]()))
	}
}
