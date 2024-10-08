enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Cocktail_App"
include(":androidApp")
include(":shared")
include(":core:domain")
include(":core:data")
include(":cocktails:domain")
include(":cocktails:data")
