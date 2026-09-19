import SwiftUI

public extension TabView {
	@MainActor
	func tabViewToolbarHandler(tabViewOption: TabViewOptions) -> some View {
		toolbar {
			ToolbarItem(placement: .principal) {
				TopAppBar(
					leftSideContent: {
						switch tabViewOption {
						case .home:
							TopAppBarTexts(
								header: String(localized: "navHome", bundle: .HomeBundle),
								paragraph: String(localized: "navHomeDescription", bundle: .HomeBundle)
							)
						case .search:
							TopAppBarTexts(
								header: String(localized: "navSearch", bundle: .SearchBundle),
								paragraph: String(localized: "navSearchByNameDescription", bundle: .SearchBundle)
							)
						case .favourites:
							TopAppBarTexts(
								header: String(localized: "navFavourites", bundle: .FavouritesBundle),
								paragraph: String(localized: "navFavouritesDescription", bundle: .FavouritesBundle)
							)
						}
					}
				)
			}
		}
		.navigationBarTitleDisplayMode(.inline)
		.toolbarBackground(Color("Container", bundle: .CoreBundle), for: .navigationBar)
		.toolbarBackground(.visible, for: .navigationBar)
	}
}
