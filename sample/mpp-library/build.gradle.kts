/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    id("android-base-convention")
    id("detekt-convention")
    id("org.jetbrains.kotlin.multiplatform")
    id("dev.icerock.mobile.multiplatform.android-manifest")
    id("kotlin-parcelize")
    id("dev.icerock.mobile.multiplatform.ios-framework")
}

kotlin {
    ios()
    iosSimulatorArm64()
    macosX64()
    macosArm64()
    android()
}

dependencies {
    commonMainApi(projects.parcelize)
    commonMainApi("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
}
