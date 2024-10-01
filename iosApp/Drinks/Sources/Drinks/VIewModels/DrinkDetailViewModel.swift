import Combine
import Core
import Foundation
import Shared
import SwiftUI

public class DrinkDetailViewModel: ObservableObject {
	private let drinksLocalRepository: DrinksLocalRepository = DrinksLocalRepositoryProvider().drinksLocalRepository
	private let drinksRepository: DrinksRepository = DrinksRepositoryProvider().drinksRepository
	private let drinkId: String

	@Published var drink: DataState<Drink> = .loading

	public init(drinkId: String) {
		self.drinkId = drinkId
		fetchDrink()
	}

	private func fetchDrink() {
		drink = .loading
		Task {
			let localResult = try await drinksLocalRepository.getDrink(drinkId: drinkId)
			let networkResult = try await drinksRepository.getDrinkById(id: drinkId)
			if let networkError = networkResult.error {
				if let localError = localResult.error {
					Just(.error(error: networkError.name)).receive(on: DispatchQueue.main).assign(to: &self.$drink)
				} else if let localData = localResult.data {
					Just(.success(data: localData)).receive(on: DispatchQueue.main).assign(to: &self.$drink)
				}
			} else if let networkData = networkResult.data {
				let currentDrink = networkData.makeCopy(
					liked: localResult.data?.liked ?? false
				)
				Just(.success(data: currentDrink)).receive(on: DispatchQueue.main).assign(to: &self.$drink)
				try await drinksLocalRepository.saveDrink(drink: currentDrink)
			}
		}
	}

	func changeFavouriteField() {
		guard case let .success(currentDrink) = drink else { return }
		let newFavouriteField = !currentDrink.liked
		let updatedDrink = currentDrink.makeCopy(liked: newFavouriteField)

		Task {
			try await drinksLocalRepository.saveDrink(drink: updatedDrink)
		}

		drink = .success(data: updatedDrink)
	}
}
