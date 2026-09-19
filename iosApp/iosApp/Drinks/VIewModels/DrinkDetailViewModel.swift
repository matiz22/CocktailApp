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
		Task { @MainActor in
			do {
				let localResult = try await drinksLocalRepository.getDrink(drinkId: drinkId)
				let networkResult = try await drinksRepository.getDrinkById(id: drinkId)
				if let networkError = networkResult.error {
					if localResult.error != nil {
						self.drink = .error(error: networkError.name)
					} else if let localData = localResult.data {
						self.drink = .success(data: localData)
					}
				} else if let networkData = networkResult.data {
					let currentDrink = networkData.makeCopy(
						liked: localResult.data?.liked ?? false
					)
					self.drink = .success(data: currentDrink)
					try await drinksLocalRepository.saveDrink(drink: currentDrink)
				}
			} catch {
				self.drink = .error(error: String(localized: "UNKNOWN", bundle: .CoreBundle))
			}
		}
	}

	func changeFavouriteField() {
		guard case let .success(currentDrink) = drink else { return }
		let updatedDrink = currentDrink.makeCopy(liked: !currentDrink.liked)

		drink = .success(data: updatedDrink)

		Task { @MainActor in
			do {
				try await drinksLocalRepository.saveDrink(drink: updatedDrink)
			} catch {
				self.drink = .success(data: currentDrink)
			}
		}
	}
}
