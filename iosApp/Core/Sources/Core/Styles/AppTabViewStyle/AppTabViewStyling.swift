import SwiftUI

public extension View {
	func tabViewThemeColors() -> some View {
		tint(
			Color("OnContainer", bundle: .CoreBundle)
		)
		.onAppear {
			UITabBar.appearance().backgroundColor = UIColor(
				named: "Container",
				in: .CoreBundle,
				compatibleWith: nil
			)?.withAlphaComponent(0.8)
		}
	}
}
