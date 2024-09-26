import Core
import SwiftUI

public struct HomeScreen: View {
	@ObservedObject private var homeViewModel = HomeScreenViewModel()
	public init() {}

	public var body: some View {
		ZStack {
			Color("Background", bundle: .CoreBundle).ignoresSafeArea()
			VStack {
				switch homeViewModel.recentDrinks {
				case let .success(drinks):
					RecentDrinksViews(recentDrinks: drinks)

				case .loading:
					Text("Loading...")

				case let .error(error):
					Text("Error: \(error)")
				}
				Spacer()
			}
		}
	}
}

#Preview {
	HomeScreen()
}
