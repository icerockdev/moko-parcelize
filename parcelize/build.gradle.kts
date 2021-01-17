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

        val intermediateSourceSets = listOf(commonMain, notAndroidMain)
        matching { sourceSet ->
            !sourceSet.name.startsWith("android") && sourceSet !in intermediateSourceSets
        }.all {
            dependsOn(notAndroidMain)
        }
    }

    // Make sure to avoid duplicate publications
    publishing {
        val publicationsFromMainHost =
            listOf(android(), wasm32(), jvm(), js()).map { it.name } + "kotlinMultiplatform"

        publications {
            matching { it.name in publicationsFromMainHost }.all{
                val targetPublication = this@all
                tasks.withType<AbstractPublishToMaven>()
                    .matching { it.publication == targetPublication }
                    .configureEach { onlyIf { System.getProperty("IS_MAIN_HOST") == "true" } }
            }
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
