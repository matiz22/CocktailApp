import Core
import Drinks
import SwiftUI

public struct FavouritesScreen: View {
	@StateObject private var favouritesViewModel: FavouritesViewModel = .init()

	public init() {}

	public var body: some View {
		ZStack {
			Color("Background", bundle: .CoreBundle).ignoresSafeArea()
			VStack {
				ScrollView {
					LazyVStack {
						Spacer().frame(height: 8)
						ForEach(favouritesViewModel.favourites.drinks, id: \.id) { drink in
							DrinkHorizontalPosition(drink: drink, withLike: true)
						}
					}
				}
			}
		}
	}
}
