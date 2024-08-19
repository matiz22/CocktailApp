plugins {
    // trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.composeCompiler).apply(false)
//    alias(libs.plugins.kotlinParcelize).apply(false)
}

buildscript {
    dependencies {
        classpath(libs.libres.gradle.plugin)
    }
}
