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
			}
		}
	}
}

#Preview {
	NavigationStack {
		SearchByNameScreen()
	}
}
