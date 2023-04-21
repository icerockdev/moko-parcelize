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
    iosSimulatorArm64()
    macosX64()
    macosArm64()
    tvos()
    tvosSimulatorArm64()
    watchos()
    watchosSimulatorArm64()
    jvm()
    js(BOTH) {
        nodejs()
        browser()
    }
    linux()
    windows()
    wasm32()

    sourceSets {

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

