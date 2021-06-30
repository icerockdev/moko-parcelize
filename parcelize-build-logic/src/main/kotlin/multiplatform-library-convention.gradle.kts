/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
    id("android-base-convention")
    id("dev.icerock.mobile.multiplatform.android-manifest")
}

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    ios()
    macosX64("macOS")
    tvos()
    watchos()
    jvm()
    js(BOTH) {
        nodejs()
        browser()
    }
    linux()
    windows()
    wasm32()

    sourceSets {
        all {
            languageSettings.apply {
                useExperimentalAnnotation("kotlin.RequiresOptIn")
            }
        }

        val commonMain by getting

        val notAndroidMain by creating {
            dependsOn(commonMain)
        }

        val intermediateSourceSets = listOf(commonMain, notAndroidMain)
        matching { sourceSet ->
            !sourceSet.name.startsWith("android") && sourceSet !in intermediateSourceSets
        }.all {
            dependsOn(notAndroidMain)
        }
    }
}

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.linux() {
    linuxArm64()
    linuxArm32Hfp()
    linuxMips32()
    linuxMipsel32()
    linuxX64()
}

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.windows() {
    mingwX64()
    mingwX86()
}

