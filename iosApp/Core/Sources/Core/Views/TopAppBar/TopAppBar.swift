import SwiftUI

public struct TopAppBar: View {
	@ViewBuilder private let leftSideContent: () -> AnyView
	@ViewBuilder private let rightSideContent: () -> AnyView

	public init(@ViewBuilder leftSideContent: @escaping () -> some View = { EmptyView() },
	            @ViewBuilder rightSideContent: @escaping () -> some View = { EmptyView() })
	{
		self.leftSideContent = { AnyView(leftSideContent()) }
		self.rightSideContent = { AnyView(rightSideContent()) }
	}

	public var body: some View {
		HStack(alignment: .center) {
			leftSideContent()
				.frame(maxWidth: .infinity, alignment: .leading)
			Spacer()
			rightSideContent()
				.frame(maxWidth: .infinity, alignment: .trailing)
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
						TopAppBarTexts(
							header: String(localized: "navHome"),
							paragraph: String(localized: "navHomeDescription")
						)
					}
				)
			})
		})
		.navigationBarTitleDisplayMode(.inline)
		.toolbarBackground(Color("Container", bundle: .CoreBundle), for: .navigationBar)
		.toolbarBackground(.visible, for: .navigationBar)
	}
}
