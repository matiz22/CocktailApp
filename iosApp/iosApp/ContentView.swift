import Core
import Home
import Shared
import SwiftUI

struct ContentView: View {
	var body: some View {
		TabView {
			HomeGraph().tabItem {
				Image("home", bundle: .HomeBundle)
			}
		}.tabViewThemeColors()
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
