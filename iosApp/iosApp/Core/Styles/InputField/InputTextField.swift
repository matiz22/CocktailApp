import SwiftUI

public struct InputTextFieldStyle: TextFieldStyle {
	@FocusState private var focused: Bool
	@ViewBuilder private let leftView: AnyView
	@ViewBuilder private let rightView: AnyView
	private let error: String?

	public init(
		leftView: some View = EmptyView(),
		rightView: some View = EmptyView(),
		error: String? = nil
	) {
		self.leftView = AnyView(leftView)
		self.rightView = AnyView(rightView)
		self.error = error
	}

	public func _body(configuration: TextField<Self._Label>) -> some View {
		VStack(alignment: .leading) {
			HStack(alignment: /*@START_MENU_TOKEN@*/ .center/*@END_MENU_TOKEN@*/, spacing: 1) {
				leftView.padding(.leading)
				configuration
					.focused($focused)
					.padding(.vertical)
					.padding(.horizontal, 24)
					.font(.paragraphLarge)

				rightView.padding(.trailing)
			}
			.background(
				Color("Container", bundle: .CoreBundle)
			)
			.clipShape(Capsule(style: .continuous))
			.overlay(alignment: .center) {
				if error?.isEmpty == false {
					Capsule(style: .continuous)
						.stroke(Color("Error", bundle: .CoreBundle), lineWidth: 2)
				} else if focused {
					Capsule(style: .continuous)
						.stroke(Color("BrandAccent", bundle: .CoreBundle), lineWidth: 2)
				} else {
					Capsule(style: .continuous)
						.stroke(Color("Container", bundle: .CoreBundle), lineWidth: 2)
				}
			}
			.onTapGesture {
				focused = true
			}
			Text(error ?? "")
				.font(.paragraphSmall)
				.foregroundStyle(Color("Error", bundle: .CoreBundle))
				.padding(2)
		}
	}
}

#Preview {
	@State var inputText = ""
	return VStack {
		TextField("Hello", text: $inputText).textFieldStyle(InputTextFieldStyle())
		TextField("Hello", text: $inputText).textFieldStyle(InputTextFieldStyle(leftView: Image("arrow_left", bundle: .CoreBundle)))
		TextField("Hello", text: $inputText).textFieldStyle(InputTextFieldStyle(leftView: Image("arrow_left", bundle: .CoreBundle), rightView: Image("arrow_left", bundle: .CoreBundle)))
		TextField("Hello", text: $inputText).textFieldStyle(InputTextFieldStyle(rightView: Image("arrow_left", bundle: .CoreBundle)))
		TextField("Hello", text: $inputText).textFieldStyle(InputTextFieldStyle(rightView: Image("arrow_left", bundle: .CoreBundle), error: "Error"))
	}
}
