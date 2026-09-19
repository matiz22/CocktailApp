import Foundation
import SwiftUI

public enum GothicA1Font {
	public static func registerFonts() {
		GothicA1Cases.allCases.forEach {
			registerFont(bundle: .CoreBundle, fontName: $0.rawValue, fontExtension: "ttf")
		}
	}

	fileprivate static func registerFont(bundle: Bundle, fontName: String, fontExtension: String) {
		guard let fontURL = bundle.url(forResource: fontName, withExtension: fontExtension),
		      let fontDataProvider = CGDataProvider(url: fontURL as CFURL),
		      let font = CGFont(fontDataProvider)
		else {
			fatalError("Couldn't create font from filename: \(fontName) with extension \(fontExtension)")
		}
		var error: Unmanaged<CFError>?
		CTFontManagerRegisterGraphicsFont(font, &error)
	}
}
