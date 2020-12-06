plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
}

version = "1.0-SNAPSHOT"

kotlin {
    android()
    ios()
    cocoapods {
        frameworkName = "Shared2"
        summary = frameworkName
        homepage = "-"
        license = "-"
        ios.deploymentTarget = "13.0"
    }
    sourceSets {
        sourceSets {
            val commonMain by getting
            val androidMain by getting {
                dependencies {
                    implementation("com.google.android.material:material:1.2.1")
                }
            }
            val iosMain by getting
        }
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
}