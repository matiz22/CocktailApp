import SwiftUI

public struct TopAppBarTexts: View {
	private let header: String
	private let paragraph: String

	public init(header: String, paragraph: String) {
		self.header = header
		self.paragraph = paragraph
	}

	public var body: some View {
		VStack(alignment: .leading, spacing: 2) {
			Text(header).font(.heading2)
			Text(paragraph).font(.paragraphLarge)
		}
	}
}
