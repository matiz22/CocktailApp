import SwiftUI

public extension View {
	func disableBounces() -> some View {
		modifier(DisableBouncesModifier())
	}
}

public struct DisableBouncesModifier: ViewModifier {
	public func body(content: Content) -> some View {
		content
			.onAppear {
				UIScrollView.appearance().bounces = false
			}
			.onDisappear {
				UIScrollView.appearance().bounces = true
			}
	}
}
