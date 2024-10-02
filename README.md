
# CocktailApp

CocktailApp is simple mobile application that displays drink recipes from [TheCocktailDB](https://www.thecocktaildb.com/). Built with Kotlin Multiplatform, it offers a seamless experience across Android and iOS devices.

![](screenshots/appPresentation.gif)

## Motivation
Reasons why I am making this app:
* 🚀 I was eager to dive into iOS development, and Swift seemed like the perfect starting point. SwiftUI also caught my attention, making it the ideal choice for exploring new tech.
* 🎨 I wanted to experiment with project tools like code formatters and Figma.
* 🔧 I’m also testing out new Kotlin Multiplatform Mobile (KMM) libraries like Room, to expand my knowledge and see how they fit into cross-platform projects.



## Features

- 🌐 Offline Caching: Enjoy access to your favorite/recent drinks even without an internet connection. The app stores data locally, so you can browse previously viewed drinks anytime, anywhere.
- 🔍 Search Functionality: Easily find drinks by name (for now).
- ⭐ Favorites: Save your favorite drinks to a dedicated list, allowing you to quickly access and revisit the cocktails you love the most.


## Tech Stack

- 🛠 Kotlin Multiplatform Mobile (KMM): A framework that allows shared code between iOS and Android, reducing duplication while maintaining native performance on both platforms.
- 📱 SwiftUI: A declarative framework for building intuitive user interfaces for iOS, allowing seamless integration with the iOS ecosystem.
- 🛩️ Jetpack Compose: Android's modern UI toolkit, used to create native UIs with a fully declarative approach for Android devices.
- 🌐 Ktor: A lightweight and flexible framework for building asynchronous servers and clients in Kotlin, perfect for handling network requests and API calls.
- 💉 Koin: A practical and lightweight dependency injection framework, ensuring modularity and easy management of dependencies across shared and platform-specific code.
- 🗄 Room multiplatform: A robust SQLite library for local data storage on Android, used for offline caching and persistent storage.
- 🖼 Coil: An image loading library for Android, providing fast and efficient image handling with built-in caching support.


## Run Locally

Clone the project

```bash
  git clone --depth 1 --branch master https://github.com/matiz22/CocktailApp.git
```
To run the app on both platforms:

- Android: Open the project in Android Studio, select your emulator or connected device, and click Run to launch the app.
- iOS: Open the iosApp folder in Xcode, choose your simulator or device, and hit Run to start the app.
  No additional setup is required just open the project in the respective editor and you're ready to go!



## Roadmap

- 🎨 UI Fixes:
  - Tweak and adjust color schemes for better consistency and user experience.
  - Refine button and text alignment to improve overall app aesthetics.
- 🏠 More Features on Home Screen:
  - Add additional sections or recommendations for popular or seasonal drinks.
  - Implement dynamic content based on user preferences or trending cocktails.
- 🔔 Daily Drink Notification:
  - Implement a daily notification feature that suggests a new drink every day, encouraging users to explore different options.
- 🔗 Sharing a Drink:
  - Allow users to share their favorite drinks with friends via social media or messaging apps, including drink details and images.

## Related

Here are some related projects
[App design](https://www.figma.com/community/file/1076609425686201098)
[App logo](https://www.svgrepo.com/svg/444797/drink-cocktail)

## Contributing

- 🟣 Kotlin Code:
ktlint with Jetpack Compose rules
- 🟡 Swift Code:
SwiftFormat

Editor configs are included in repo
