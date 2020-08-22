/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

object Deps {
    private const val kotlinVersion = "1.4.0"
    private const val androidAppCompatVersion = "1.1.0"
    const val mokoParcelizeVersion = "0.4.0"

    object Android {
        const val compileSdk = 28
        const val targetSdk = 28
        const val minSdk = 16
    }

    object Plugins {
        val androidExtensions = GradlePlugin(
            id = "kotlin-android-extensions",
            module = "org.jetbrains.kotlin:kotlin-android-extensions:$kotlinVersion"
        )
        val androidLibrary = GradlePlugin(id = "com.android.library")
        val androidApplication = GradlePlugin(id = "com.android.application")
        val kotlinMultiPlatform = GradlePlugin(id = "org.jetbrains.kotlin.multiplatform")
        val kotlinAndroid = GradlePlugin(id = "kotlin-android")
        val kotlinKapt = GradlePlugin(id = "kotlin-kapt")
        val mobileMultiPlatform = GradlePlugin(id = "dev.icerock.mobile.multiplatform")
        val iosFramework = GradlePlugin(id = "dev.icerock.mobile.multiplatform.ios-framework")
        val mavenPublish = GradlePlugin(id = "maven-publish")
    }

    object Libs {
        object Android {
            val appCompat = AndroidLibrary(
                name = "androidx.appcompat:appcompat:$androidAppCompatVersion"
            )
        }

        object MultiPlatform {
            val mokoParcelize = MultiPlatformLibrary(
                common = "dev.icerock.moko:parcelize:$mokoParcelizeVersion"
            )
        }
    }
}