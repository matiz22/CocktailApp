import SwiftUI

public struct TopAppBar<LeftSideContent: View, RightSideContent: View>: View {
	@ViewBuilder public let leftSideContent: (() -> LeftSideContent)?
	@ViewBuilder public let rightSideContent: (() -> RightSideContent)?

	public init(leftSideContent: (() -> LeftSideContent)? = { EmptyView() }, rightSideContent: (() -> RightSideContent)? = { EmptyView() }) {
		self.leftSideContent = leftSideContent
		self.rightSideContent = rightSideContent
	}

	public var body: some View {
		HStack(alignment: .center) {
			leftSideContent?()
			Spacer()
			rightSideContent?()
		}
	}
}

#Preview {
	NavigationStack {
		VStack {
			Text("Hello").font(.paragraphSmall)

		}.toolbar(content: {
			ToolbarItem(placement: .principal, content: {
				TopAppBar(
					leftSideContent: {
						Button(action: { print("hello") }, label: {
							Image("arrow_left", bundle: .CoreBundle).tint(Color("OnBackground", bundle: .CoreBundle))
						})
					},
					rightSideContent: {
						VStack {
							Text("Hello").font(.heading1)
							Text("hello")
						}
					}
				)
			})
		})
	}
}
