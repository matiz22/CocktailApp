import SwiftUI

public extension TextFieldStyle where Self == InputTextFieldStyle {
	static var inputTextStyle: Self { Self() }
	static func inputTextField(
		leftView: some View = EmptyView(),
		rightView: some View = EmptyView(),
		error: String? = nil
	) -> Self {
		Self(leftView: leftView, rightView: rightView, error: error)
	}
}
