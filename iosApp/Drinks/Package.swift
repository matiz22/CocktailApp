// swift-tools-version: 5.10

import PackageDescription

let package = Package(
	name: "Drinks",
	platforms: [.iOS(.v16)],
	products: [
		.library(
			name: "Drinks",
			targets: ["Drinks"]
		),
	],
	dependencies: [.package(path: "Core")],
	targets: [
		.target(
			name: "Drinks",
			dependencies: ["Core"]
		),
		.testTarget(
			name: "DrinksTests",
			dependencies: ["Drinks"]
		),
	]
)
