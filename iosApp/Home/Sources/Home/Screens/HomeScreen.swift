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

			}.toolbar {
				ToolbarItem(placement: .principal) {
					TopAppBar(
						leftSideContent: {
							TopAppBarTexts(
								header: String(localized: "navHome", bundle: .HomeBundle),
								paragraph: String(localized: "navHomeDescription", bundle: .HomeBundle)
							)
						}
					)
				}
			}
			.navigationBarTitleDisplayMode(.inline)
			.toolbarBackground(Color("Container", bundle: .CoreBundle), for: .navigationBar)
			.toolbarBackground(.visible, for: .navigationBar)
			.task {
				await self.homeViewModel.fetchDrinks()
			}
		}
	}
}

#Preview {
	HomeScreen()
}
