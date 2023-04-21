plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()

    gradlePluginPortal()
}

dependencies {
    api("dev.icerock:mobile-multiplatform:0.13.0")
    api("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
    api("com.android.tools.build:gradle:7.4.2")
    api("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.22.0")
}
