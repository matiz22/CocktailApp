// swift-tools-version: 5.10

import PackageDescription

let package = Package(
	name: "Home",
	platforms: [.iOS(.v16)],
	products: [
		.library(
			name: "Home",
			targets: ["Home"]
		),
	],
	dependencies: [.package(path: "Core"), .package(path: "Drinks")],
	targets: [
		.target(
			name: "Home",
			dependencies: ["Core", "Drinks"]
		),
		.testTarget(
			name: "HomeTests",
			dependencies: ["Home"]
		),
	]
)
