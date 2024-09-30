import Core
import Shared
import SwiftUI

public struct DrinkInfoView: View {
	private let drink: Drink

	public init(drink: Drink) {
		self.drink = drink
	}

	public var body: some View {
		VStack(alignment: .leading, spacing: 6) {
			Text(drink.name).font(.heading1)
			Text(drink.category).font(.paragraphLarge).foregroundStyle(Color("FontLight", bundle: .CoreBundle))
			Text(drink.alcoholic).font(.paragraphLarge).foregroundStyle(Color("FontLight", bundle: .CoreBundle))
			Text(drink.glass).font(.paragraphLarge).foregroundStyle(Color("FontLight", bundle: .CoreBundle))
		}
	}
}
