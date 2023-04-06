/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.parcelize

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.TypeParceler

actual typealias Parcelize = Parcelize

actual typealias Parcelable = Parcelable

actual typealias IgnoredOnParcel = IgnoredOnParcel

actual typealias Parceler<P> = Parceler<P>

actual typealias TypeParceler<T, P> = TypeParceler<T, P>

actual typealias Parcel = android.os.Parcel
