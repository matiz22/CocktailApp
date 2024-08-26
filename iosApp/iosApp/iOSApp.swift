import Core
import SwiftUI

@main
struct iOSApp: App {
	init() {
		GothicA1Font.registerFonts()
	}

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
