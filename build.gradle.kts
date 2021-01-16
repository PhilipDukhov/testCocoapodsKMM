buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven { url = java.net.URI("https://dl.bintray.com/icerockdev/plugins") }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath("com.android.tools.build:gradle:7.0.0-alpha04")
        classpath("dev.icerock.moko:resources-generator:0.14.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url = java.net.URI("https://dl.bintray.com/icerockdev/moko") }
    }
}