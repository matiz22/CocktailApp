import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    id("io.github.skeptick.libres")
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions.jvmTarget.set(JvmTarget.JVM_1_8)
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "Shared"
            isStatic = true
            export(projects.cocktails.domain)
            export(projects.cocktails.data)
            export(projects.core.domain)
            export(projects.core.data)
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.cocktails.domain)
            api(projects.cocktails.data)
            api(projects.core.domain)
            api(projects.core.data)
            api(libs.koin.core)
            api(libs.room.runtime)
            api(libs.ktor.client.core)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "pl.matiz22.cocktailapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

libres {
    generatedClassName = "SharedRes"
    camelCaseNamesForAppleFramework = true
    baseLocaleLanguageCode = "en"
}
