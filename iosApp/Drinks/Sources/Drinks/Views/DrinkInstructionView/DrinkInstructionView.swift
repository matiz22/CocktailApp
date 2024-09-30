import SwiftUI

public struct DrinkInstructionView: View {
	private let instructions: String

	public init(instructions: String) {
		self.instructions = instructions
	}

	public var body: some View {
		VStack(alignment: .leading) {
			Text(String(localized: "instructions", bundle: .DrinksBundle)).font(.heading3)
			Text(self.instructions).font(.paragraphSmall)
		}
	}
}
