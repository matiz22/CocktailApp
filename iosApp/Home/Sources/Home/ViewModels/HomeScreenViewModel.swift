import Core
import Shared

public class HomeScreenViewModel: ObservableObject {
	private let drinksLocalRepository: DrinksLocalRepository = DrinksLocalRepositoryProvider().drinksLocalRepository
	@Published private(set) var recentDrinks: DataState<Drinks> = .loading

	public init() {
		Task {
			await fetchDrinks()
		}
	}

	func fetchDrinks() async {
		await MainActor.run {
			recentDrinks = .loading
		}
		do {
			let drinksData = try await drinksLocalRepository.getRecentDrinks()
			await MainActor.run {
				if let data = drinksData.data {
					recentDrinks = .success(data: data)
				} else if let error = drinksData.error {
					recentDrinks = .error(error: String(reflecting: error))
				}
			}
		} catch {
			await MainActor.run {
				recentDrinks = .error(error: String(localized: "UNKNOWN", bundle: .CoreBundle))
			}
		}
	}
}
