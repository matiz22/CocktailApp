// swift-tools-version: 5.10

import PackageDescription

let package = Package(
	name: "Core",
	platforms: [.iOS(.v15)],
	products: [
		.library(
			name: "Core",
			targets: ["Core"]
		),
	],
	targets: [
		.target(
			name: "Core",
			resources: [.process("Resources/Fonts")]
		),
		.testTarget(
			name: "CoreTests",
			dependencies: ["Core"]
		),
	]
)
