// swift-tools-version: 6.0

import PackageDescription

let package = Package(
	name: "Search",
	platforms: [.iOS(.v16)],
	products: [
		.library(
			name: "Search",
			targets: ["Search"]
		),
	],
	dependencies: [.package(path: "Core"), .package(path: "Drinks")],
	targets: [
		.target(
			name: "Search",
			dependencies: ["Core", "Drinks"]
		),
		.testTarget(
			name: "SearchTests",
			dependencies: ["Search"]
		),
	]
)
