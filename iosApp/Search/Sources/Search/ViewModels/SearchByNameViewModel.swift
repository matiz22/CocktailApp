import Combine
import Core
import Foundation
import Shared

public class SearchByNameViewModel: ObservableObject {
	private let drinksRepository: DrinksRepository = DrinksRepositoryProvider().drinksRepository
	private var cancellables = Set<AnyCancellable>()
	@Published private(set) var drinks: Drinks = .init(drinks: [])
	@Published var query: String = ""

	public init() {
		setupFetching()
	}

	private func setupFetching() {
		$query
			.debounce(for: .milliseconds(500), scheduler: RunLoop.main)
			.sink { text in
				if !text.trimmingCharacters(in: .whitespaces).isEmpty {
					self.fetchDrinks(query: text)
				}
			}
			.store(in: &cancellables)
	}

	private func fetchDrinks(query: String) {
		drinksRepository.getDrinksByName(query: query, completionHandler: { result, _ in
			if let data = result?.data {
				Just(data).receive(on: DispatchQueue.main).assign(to: &self.$drinks)
			}
			// TODO: make error handling for search
		})
	}
}
