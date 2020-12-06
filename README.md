1. wait project sync to finish, build xcode project.
2. [TODO 1](shared/build.gradle.kts#L27): uncomment dependency in shared module gradle, then `sync`:

```
> Task :shared:generateDefFBSDKCoreKit UP-TO-DATE
> Task :shared:podDownload UP-TO-DATE
> Task :shared:generateDummyFramework
> Task :shared:podspec UP-TO-DATE
> Task :shared:podGenIOS UP-TO-DATE
> Task :shared:podSetupBuildFBSDKCoreKitIphoneos UP-TO-DATE
> Task :shared:podBuildFBSDKCoreKitIphoneos
> Task :shared:cinteropFBSDKCoreKitIosArm64
> Task :shared:podSetupBuildFBSDKCoreKitIphonesimulator UP-TO-DATE
> Task :shared:podBuildFBSDKCoreKitIphonesimulator
> Task :shared:cinteropFBSDKCoreKitIosX64
> Task :shared:generateDefFBSDKLoginKit UP-TO-DATE
> Task :shared:podSetupBuildFBSDKLoginKitIphoneos UP-TO-DATE
> Task :shared:podBuildFBSDKLoginKitIphoneos UP-TO-DATE
> Task :shared:cinteropFBSDKLoginKitIosArm64 
> Task :shared:podSetupBuildFBSDKLoginKitIphonesimulator UP-TO-DATE
> Task :shared:podBuildFBSDKLoginKitIphonesimulator UP-TO-DATE
> Task :shared:cinteropFBSDKLoginKitIosX64
> Task :shared:generateDefFirebaseCore UP-TO-DATE
> Task :shared:podSetupBuildFirebaseIphoneos UP-TO-DATE
> Task :shared:podBuildFirebaseIphoneos UP-TO-DATE
> Task :shared:cinteropFirebaseCoreIosArm64
> Task :shared:podSetupBuildFirebaseIphonesimulator UP-TO-DATE
> Task :shared:podBuildFirebaseIphonesimulator UP-TO-DATE
> Task :shared:cinteropFirebaseCoreIosX64
> Task :shared:generateDefGoogleSignIn UP-TO-DATE
> Task :shared:podSetupBuildGoogleSignInIphoneos UP-TO-DATE
> Task :shared:podBuildGoogleSignInIphoneos UP-TO-DATE
> Task :shared:cinteropGoogleSignInIosArm64
> Task :shared:podSetupBuildGoogleSignInIphonesimulator UP-TO-DATE
> Task :shared:podBuildGoogleSignInIphonesimulator UP-TO-DATE
> Task :shared:cinteropGoogleSignInIosX64
> Task :shared:podInstall SKIPPED
> Task :shared:podImport
> Task :shared:runCommonizer UP-TO-DATE
> Task :prepareKotlinBuildScriptModel UP-TO-DATE

BUILD SUCCESSFUL in 1m 47s
```
expected behavior: cinterop tasks should be UP-TO-DATE.

3. build xcode project:

```
> Task :shared:generateDefFBSDKCoreKit UP-TO-DATE
> Task :shared:cinteropFBSDKCoreKitIosX64
> Task :shared:generateDefFBSDKLoginKit UP-TO-DATE
> Task :shared:cinteropFBSDKLoginKitIosX64
> Task :shared:generateDefFirebaseCore UP-TO-DATE
> Task :shared:cinteropFirebaseCoreIosX64
> Task :shared:generateDefGoogleSignIn UP-TO-DATE
> Task :shared:cinteropGoogleSignInIosX64
> Task :shared:compileKotlinIosX64
> Task :shared:linkDebugFrameworkIosX64
> Task :shared:syncFramework

BUILD SUCCESSFUL in 47s
```
expected behavior: cinterop tasks should be UP-TO-DATE, both because nothing related changed, and because we just processed same tasks in step 2.

4. [TODO 2](shared/build.gradle.kts#L27): uncomment dependency in project gradle, then `sync`:

```
> Task :shared:generateDefFBSDKCoreKit
> Task :shared:podDownload UP-TO-DATE
> Task :shared:generateDummyFramework
> Task :shared:podspec
> Task :shared:podGenIOS
> Task :shared:podSetupBuildFBSDKCoreKitIphoneos
> Task :shared:podBuildFBSDKCoreKitIphoneos
> Task :shared:cinteropFBSDKCoreKitIosArm64
> Task :shared:podSetupBuildFBSDKCoreKitIphonesimulator
> Task :shared:podBuildFBSDKCoreKitIphonesimulator
> Task :shared:cinteropFBSDKCoreKitIosX64
> Task :shared:generateDefFBSDKLoginKit
> Task :shared:podSetupBuildFBSDKLoginKitIphoneos
> Task :shared:podBuildFBSDKLoginKitIphoneos
> Task :shared:cinteropFBSDKLoginKitIosArm64
> Task :shared:podSetupBuildFBSDKLoginKitIphonesimulator
> Task :shared:podBuildFBSDKLoginKitIphonesimulator
> Task :shared:cinteropFBSDKLoginKitIosX64
> Task :shared:generateDefFirebaseCore
> Task :shared:podSetupBuildFirebaseIphoneos
> Task :shared:podBuildFirebaseIphoneos
> Task :shared:cinteropFirebaseCoreIosArm64
> Task :shared:podSetupBuildFirebaseIphonesimulator
> Task :shared:podBuildFirebaseIphonesimulator
> Task :shared:cinteropFirebaseCoreIosX64
> Task :shared:generateDefGoogleSignIn
> Task :shared:podSetupBuildGoogleSignInIphoneos
> Task :shared:podBuildGoogleSignInIphoneos
> Task :shared:cinteropGoogleSignInIosArm64
> Task :shared:podSetupBuildGoogleSignInIphonesimulator
> Task :shared:podBuildGoogleSignInIphonesimulator
> Task :shared:cinteropGoogleSignInIosX64
> Task :shared:podInstall SKIPPED
> Task :shared:podImport
> Task :shared:runCommonizer
> Task :prepareKotlinBuildScriptModel UP-TO-DATE

BUILD SUCCESSFUL in 3m 37s
```
expected behavior: same as in 2.

5. build xcode project:

```
> Task :shared:generateDefFBSDKCoreKit UP-TO-DATE
> Task :shared:cinteropFBSDKCoreKitIosX64
> Task :shared:generateDefFBSDKLoginKit UP-TO-DATE
> Task :shared:cinteropFBSDKLoginKitIosX64
> Task :shared:generateDefFirebaseCore UP-TO-DATE
> Task :shared:cinteropFirebaseCoreIosX64
> Task :shared:generateDefGoogleSignIn UP-TO-DATE
> Task :shared:cinteropGoogleSignInIosX64
> Task :shared:compileKotlinIosX64
> Task :shared:linkDebugFrameworkIosX64
> Task :shared:syncFramework

BUILD SUCCESSFUL in 55s
```
expected behavior: same as in 3.