import Core
import Shared

public class HomeScreenViewModel {
	private let drinksLocalRepository: DrinksLocalRepository = DrinksLocalRepositoryProvider().drinksLocalRepository
	@Published private(set) var recentDrinks: DataState<Drinks> = .loading

	public init() {}

	func fetchDrinks() async {
		recentDrinks = .loading
		do {
			let drinksData = try await drinksLocalRepository.getRecentDrinks()
			if let data = drinksData.data {
				recentDrinks = .success(data: data)
			} else if let error = drinksData.error {
				recentDrinks = .error(error: String(reflecting: error))
			}
		} catch {
			recentDrinks = .error(error: String(localized: "UNKNOWN", bundle: .CoreBundle))
		}
	}
}
