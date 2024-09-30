import SwiftUI

public struct ScrollViewWithOffsets<Content: View>: View {
	let content: Content
	@Binding var contentOffset: CGFloat

	public init(contentOffset: Binding<CGFloat>, @ViewBuilder content: () -> Content) {
		_contentOffset = contentOffset
		self.content = content()
	}

	public var body: some View {
		ScrollView {
			content
				.background {
					GeometryReader { geometry in
						Color.clear
							.preference(key: ContentOffsetKey.self, value: geometry.frame(in: .named("scrollView")).minY)
					}
				}
		}
		.coordinateSpace(name: "scrollView")
		.onPreferenceChange(ContentOffsetKey.self) { value in
			self.contentOffset = value
		}
	}
}
