/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    plugin(Deps.Plugins.androidLibrary)
    plugin(Deps.Plugins.kotlinMultiPlatform)
    plugin(Deps.Plugins.kotlinParcelize)
    plugin(Deps.Plugins.mobileMultiPlatform)
    plugin(Deps.Plugins.mavenPublish)
}

group = "dev.icerock.moko"
version = Deps.mokoParcelizeVersion

kotlin {
    macosX64("macOS")
    tvos()
    watchos()
    jvm()
    js {
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
        val macOSMain by getting {
            dependsOn(notAndroidMain)
        }
        val tvosMain by getting {
            dependsOn(notAndroidMain)
        }
        val watchosMain by getting {
            dependsOn(notAndroidMain)
        }
        val jvmMain by getting {
            dependsOn(notAndroidMain)
        }
        val jsMain by getting {
            dependsOn(notAndroidMain)
        }
        val iosMain by getting {
            dependsOn(notAndroidMain)
        }
        val linuxArm64Main by getting {
            dependsOn(notAndroidMain)
        }
        val linuxArm32HfpMain by getting {
            dependsOn(notAndroidMain)
        }
        val linuxMips32Main by getting {
            dependsOn(notAndroidMain)
        }
        val linuxMipsel32Main by getting {
            dependsOn(notAndroidMain)
        }
        val linuxX64Main by getting {
            dependsOn(notAndroidMain)
        }
        val mingwX64Main by getting {
            dependsOn(notAndroidMain)
        }
        val mingwX86Main by getting {
            dependsOn(notAndroidMain)
        }
        val wasm32Main by getting {
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

publishing {
    repositories.maven("https://api.bintray.com/maven/icerockdev/moko/moko-parcelize/;publish=1") {
        name = "bintray"

        credentials {
            username = System.getProperty("BINTRAY_USER")
            password = System.getProperty("BINTRAY_KEY")
        }
    }
}
