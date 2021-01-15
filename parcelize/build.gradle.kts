/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiPlatform)
    plugin(Deps.Plugins.androidExtensions)
    plugin(Deps.Plugins.mobileMultiPlatform)
    plugin(Deps.Plugins.mavenPublish)
}

group = "dev.icerock.moko"
version = Deps.mokoParcelizeVersion

kotlin {
    macosX64()
    tvos()
    watchos()
    jvm()
    js()
    linux()
    windows()
    wasm32()

    sourceSets {
        val commonMain by getting
        val androidMain by getting

        val notAndroidMain by creating {
            dependsOn(commonMain)
        }
        all {
            val independentSourceSets = listOf(commonMain, androidMain, notAndroidMain)
            if (this !in independentSourceSets) {
                dependsOn(notAndroidMain)
            }

            languageSettings.apply {
                useExperimentalAnnotation("kotlin.RequiresOptIn")
            }
        }
    }
}

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.linux(){
    linuxArm64()
    linuxArm32Hfp()
    linuxMips32()
    linuxMipsel32()
    linuxX64()
}

fun org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension.windows(){
    mingwX64()
    mingwX86()
}

publishing {
    repositories.maven("https://api.bintray.com/maven/icerockdev/moko/moko-parcelize/;publish=1") {
        name = "bintray"

        credentials {
            username = System.getProperty("BINTRAY_USER")
            password = System.getProperty("BINTRAY_KEY")
        }
    }
}
