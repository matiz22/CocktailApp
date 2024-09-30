// swift-tools-version: 6.0

import PackageDescription

let package = Package(
	name: "Favourites",
	products: [
		.library(
			name: "Favourites",
			targets: ["Favourites"]
		),
	],
	dependencies: [.package(path: "Core"), .package(path: "Drinks")],
	targets: [
		.target(
			name: "Favourites",
			dependencies: ["Core", "Drinks"]
		),
		.testTarget(
			name: "FavouritesTests",
			dependencies: ["Favourites"]
		),
	]
)
