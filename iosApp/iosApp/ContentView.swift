import Core
import Drinks
import Home
import Search
import Shared
import SwiftUI

struct ContentView: View {
	@State var selectedTab: TabViewOptions = .home
	var body: some View {
		NavigationStack {
			TabView(selection: $selectedTab) {
				HomeScreen().tabItem {
					Image("home", bundle: .HomeBundle)
				}.tag(TabViewOptions.home)

				SearchByNameScreen().tabItem {
					Image("search", bundle: .SearchBundle)
				}.tag(TabViewOptions.search)
			}
			.tabViewToolbarHandler(tabViewOption: selectedTab)
			.tabViewThemeColors()
			.navigationDestination(for: CoreRoutes.self) { route in
				switch route {
				case let .drinkDetails(drinkId):
					DrinkDetailsScreen(drinkId: drinkId).navigationBarBackButtonHidden(true)
				}
			}
		}
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
