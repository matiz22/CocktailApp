import Combine
import Core
import Foundation
import Shared

public class FavouritesViewModel: ObservableObject {
	private let drinksLocalrepository: DrinksLocalRepository = DrinksLocalRepositoryProvider().drinksLocalRepository

	@Published private(set) var favourites: Drinks = .init(drinks: [])

	public init() {
		fetchFavourites()
	}

	private func fetchFavourites() {
		drinksLocalrepository.getFavDrinks { result, _ in
			if let data = result?.data {
				Just(data).receive(on: DispatchQueue.main).assign(to: &self.$favourites)
			}
			// TODO: make error handling for search
		}
	}
}
