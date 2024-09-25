import Core
import Home
import Search
import Shared
import SwiftUI

struct ContentView: View {
	var body: some View {
		TabView {
			HomeGraph().tabItem {
				Image("home", bundle: .HomeBundle)
			}
			SearchGraph().tabItem {
				Image("search", bundle: .SearchBundle)
			}
		}.tabViewThemeColors()
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
