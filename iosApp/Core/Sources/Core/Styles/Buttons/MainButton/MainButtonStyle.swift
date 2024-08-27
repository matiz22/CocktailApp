import SwiftUI

public struct MainButtonStyle: ButtonStyle {
	public let disabled: Bool

	public init(disabled: Bool = false) {
		self.disabled = disabled
	}

	public func makeBody(configuration: Configuration) -> some View {
		configuration.label
			.foregroundStyle(Color("FontWhite", bundle: .module))
			.font(.paragraphLarge)
			.padding(EdgeInsets(top: 16, leading: 20, bottom: 16, trailing: 20))
			.background(
				LinearGradient(
					gradient: Gradient(
						colors: [
							Color("Brand05", bundle: .module).opacity(disabled ? 0.7 : 1.0),
							Color("BrandAccent", bundle: .module).opacity(disabled ? 0.7 : 1.0),
						]
					),
					startPoint: .leading, endPoint: .trailing
				)
			)
			.clipShape(Capsule())
			.scaleEffect(configuration.isPressed ? 0.80 : 1.0)
			.animation(.easeInOut(duration: 0.1), value: configuration.isPressed)
	}
}

#Preview {
	VStack {
		Button(action: { print("hello") }) {
			Text("Hello")
		}.buttonStyle(.mainButtonStyle)
		Button(action: { print("hello") }) {
			Text("Hello")
		}.buttonStyle(.mainButtonStyle(disabled: true)).disabled(true)
	}
}
