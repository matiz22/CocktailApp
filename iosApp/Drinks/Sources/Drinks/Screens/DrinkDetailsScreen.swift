import Core
import Shared
import SwiftUI

public struct DrinkDetailsScreen: View {
	private let drinkId: String

	@Environment(\.dismiss) private var dismiss

	@StateObject private var drinkDetailViewModel: DrinkDetailViewModel

	public init(drinkId: String) {
		self.drinkId = drinkId
		_drinkDetailViewModel = StateObject(wrappedValue: DrinkDetailViewModel(drinkId: drinkId))
	}

	@State private var contentOffset: CGFloat = 0

	public var body: some View {
		switch drinkDetailViewModel.drink {
		case let .success(drink):
			ZStack {
				Color("Background", bundle: .CoreBundle).ignoresSafeArea()
				ScrollViewWithOffsets(contentOffset: $contentOffset) {
					VStack(alignment: .leading) {
						AsyncImage(url: URL(string: drink.image)) { state in
							switch state {
							case let .success(image):
								image.resizable()
							default:
								Image("drink_icon", bundle: .module).resizable()
							}
						}
						.frame(minWidth: 0, maxWidth: .infinity)
						.scaledToFit()
						HStack {
							DrinkInfoView(drink: drink)
							Spacer()
							Button(
								action: { drinkDetailViewModel.changeFavouriteField() },
								label: {
									Image(drink.liked ? "heartFill" : "heartOutline", bundle: .CoreBundle)
										.tint(Color(drink.liked ? "BrandAccent" : "OnContainer", bundle: .CoreBundle))
								}
							).padding(8)
						}.padding(6)
						IngredientsAndMeasuresView(ingredientsAndMeasures: drink.ingredientsAndMeasures).padding(6)
						DrinkInstructionView(instructions: drink.instructions).padding(6)
					}
				}
				.disableBounces()
				.overlay(content: {
					VStack {
						TopAppBar(leftSideContent: {
							Button(
								action: { dismiss() },
								label: { Image("arrow_left", bundle: .CoreBundle)
									.tint(
										((contentOffset * -1) / UIScreen.main.bounds.width) > 0.5 ?
											Color("OnBackground", bundle: .CoreBundle) : Color("Monochromatic10", bundle: .CoreBundle)
									)
								}
							).padding(16)
						}).background(
							Color("Container", bundle: .CoreBundle)
								.opacity((contentOffset * -1) / UIScreen.main.bounds.width)
						)
						Spacer()
					}
				})
			}
		case .loading:
			Text("loading")
		case let .error(error):
			Text(error)
		}
	}
}
