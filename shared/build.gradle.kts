plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
    id("dev.icerock.mobile.multiplatform-resources")
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}

version = "1.0-SNAPSHOT"

multiplatformResources {
    multiplatformResourcesPackage = "com.well.myapplication"
    disableStaticFrameworkWarning = true
}

kotlin {
    android()
    ios()
    cocoapods {
        frameworkName = "Shared"
        summary = frameworkName
        homepage = "-"
        license = "-"
        ios.deploymentTarget = "13.0"
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.21")
                api("dev.icerock.moko:resources:0.14.0")
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
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    if (this !is org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget) return@configureEach

    val arch = when (this.konanTarget) {
        org.jetbrains.kotlin.konan.target.KonanTarget.IOS_ARM64 -> "iosarm64"
        org.jetbrains.kotlin.konan.target.KonanTarget.IOS_X64 -> "iosx64"
        else -> throw IllegalArgumentException()
    }

    this.binaries.configureEach {
        if (this is org.jetbrains.kotlin.gradle.plugin.mpp.Framework) {
            this.export("dev.icerock.moko:resources-$arch:0.14.0}")
        }
    }
}

// AS 7 canary bug fix
configurations {
    listOf(
        "testApi",
        "testDebugApi",
        "testReleaseApi"
    ).forEach {
        create(it) {}
    }
}