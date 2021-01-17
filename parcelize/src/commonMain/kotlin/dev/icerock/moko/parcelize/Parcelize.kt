/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.parcelize

@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
expect annotation class Parcelize()

expect interface Parcelable

@OptIn(ExperimentalMultiplatform::class)
@OptionalExpectation
expect annotation class IgnoredOnParcel()