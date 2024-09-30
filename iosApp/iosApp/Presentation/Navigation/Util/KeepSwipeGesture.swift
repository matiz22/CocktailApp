import SwiftUI

extension UINavigationController: @retroactive UIGestureRecognizerDelegate {
	override open func viewDidLoad() {
		super.viewDidLoad()
		interactivePopGestureRecognizer?.delegate = self
	}

	public func gestureRecognizerShouldBegin(_: UIGestureRecognizer) -> Bool {
		return viewControllers.count > 1
	}
}
