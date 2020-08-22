/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

buildscript {
    repositories {
        jcenter()
        google()
    }

    dependencies {
        plugin(Deps.Plugins.androidExtensions)
    }
}

allprojects {
    repositories {
        mavenLocal()

        google()
        jcenter()

        maven { url = uri("https://kotlin.bintray.com/kotlin") }
        maven { url = uri("https://kotlin.bintray.com/kotlinx") }
        maven { url = uri("https://dl.bintray.com/icerockdev/moko") }
    }

    configurations.all {
        resolutionStrategy.dependencySubstitution {
            substitute(module(Deps.Libs.MultiPlatform.mokoParcelize.common))
                .with(project(":parcelize"))
        }
    }
}

tasks.register("clean", Delete::class).configure {
    delete(rootProject.buildDir)
}
