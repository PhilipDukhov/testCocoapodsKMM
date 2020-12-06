package com.well.myapplication.shared

import cocoapods.GoogleSignIn.*
import platform.Foundation.NSError
import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.darwin.NSObject

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

    private val delegate = object : NSObject(), GIDSignInDelegateProtocol {
        override fun signIn(
            signIn: GIDSignIn?,
            didSignInForUser: GIDGoogleUser?,
            withError: NSError?
        ) {
            val token = didSignInForUser?.authentication?.idToken
            NSLog("$token")
        }
    }
}