import SwiftUI

public struct IconButtonStyle: ButtonStyle {
	public func makeBody(configuration: Configuration) -> some View {
		configuration.label
			.foregroundColor(Color("OnBackgroundColor", bundle: .module))
			.padding(8)
			.clipShape(.circle)
			.scaleEffect(configuration.isPressed ? 0.80 : 1.0)
			.animation(.easeInOut(duration: 0.1), value: configuration.isPressed)
	}
}

#Preview {
	Button(action: { print("hello") }, label: { Image("arrow_left", bundle: .module).tint(Color("OnBackground", bundle: .module)) })
}
