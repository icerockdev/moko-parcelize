/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("multiplatform-library-convention")
    id("detekt-convention")
    id("kotlin-parcelize")
    id("dev.icerock.mobile.multiplatform.android-manifest")
    id("publication-convention")
}

group = "dev.icerock.moko"
version = libs.versions.mokoParcelizeVersion.get()
