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
        frameworkName = "Shared"
        summary = frameworkName
        homepage = "-"
        license = "-"
        ios.deploymentTarget = "13"

        pod("Firebase/Core", version = "7.1.0", moduleName = "FirebaseCore")
        pod("GoogleSignIn", version = "5.0.2")
        pod("FBSDKLoginKit", version = "8.2.0")
        pod("FBSDKCoreKit", version = "8.2.0")
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                //  TODO 1 uncomment implementation
//                implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.20")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.1")
            }
        }
        val iosMain by getting
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