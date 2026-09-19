import SwiftUI

public extension ButtonStyle where Self == MainButtonStyle {
	static var mainButtonStyle: Self { Self() }
	static func mainButtonStyle(disabled: Bool = false) -> Self {
		Self(disabled: disabled)
	}
}
