plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
}

version = "1.0-SNAPSHOT"

kotlin {
    android()
    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    if (onPhone) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }
    cocoapods {
        frameworkName = "Shared"
        summary = frameworkName
        homepage = "-"
        license = "-"
        ios.deploymentTarget = "13.0"

        pod("GoogleSignIn", version = "5.0.2")
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.20")
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