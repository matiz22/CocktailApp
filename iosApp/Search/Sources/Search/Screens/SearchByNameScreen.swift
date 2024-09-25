import Core
import Drinks
import SwiftUI

public struct SearchByNameScreen: View {
	@StateObject private var searchByNameViewModel: SearchByNameViewModel = .init()
	public init() {}

	public var body: some View {
		ZStack {
			Color("Background", bundle: .CoreBundle).ignoresSafeArea()
			VStack(spacing: 0) {
				TextField("", text: $searchByNameViewModel.query).textFieldStyle(.inputTextStyle).padding(EdgeInsets(top: 24, leading: 2, bottom: 0, trailing: 2))
				ScrollView {
					LazyVStack {
						ForEach(searchByNameViewModel.drinks.drinks, id: \.id) { drink in
							DrinkHorizontalPosition(drink: drink)
						}
					}
				}
			}.toolbar {
				ToolbarItem(placement: .principal) {
					TopAppBar(
						leftSideContent: {
							TopAppBarTexts(
								header: String(localized: "navSearch", bundle: .SearchBundle),
								paragraph: String(localized: "navSearchByNameDescription", bundle: .SearchBundle)
							)
						}
					)
				}
			}
			.navigationBarTitleDisplayMode(.inline)
			.toolbarBackground(Color("Container", bundle: .CoreBundle), for: .navigationBar)
			.toolbarBackground(.visible, for: .navigationBar)
		}
	}
}

#Preview {
	NavigationStack {
		SearchByNameScreen()
	}
}
