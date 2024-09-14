import Core
import Shared
import SwiftUI

@main
struct iOSApp: App {
	init() {
		KoinIosAppInitializerKt.koinIosAppInitializer()
		GothicA1Font.registerFonts()
	}

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
