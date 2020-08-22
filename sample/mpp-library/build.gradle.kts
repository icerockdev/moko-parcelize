/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiPlatform)
    plugin(Deps.Plugins.mobileMultiPlatform)
    plugin(Deps.Plugins.androidExtensions)
    plugin(Deps.Plugins.iosFramework)
}

android {
    compileSdkVersion(Deps.Android.compileSdk)

    defaultConfig {
        minSdkVersion(Deps.Android.minSdk)
        targetSdkVersion(Deps.Android.targetSdk)
    }
}

dependencies {
    mppLibrary(Deps.Libs.MultiPlatform.mokoParcelize)
}
