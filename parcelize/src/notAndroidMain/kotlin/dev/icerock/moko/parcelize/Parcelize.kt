/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.parcelize

actual interface Parcelable
actual annotation class IgnoredOnParcel
actual annotation class Parcelize
actual interface Parceler<P> {
    actual fun create(parcel: Parcel): P
    actual fun P.write(parcel: Parcel, flags: Int)
}

actual annotation class TypeParceler<T, P : Parceler<in T>>

actual class Parcel {
    actual fun readString(): String? = null
    actual fun readByte(): Byte = 1

    actual fun readInt(): Int = 1

    actual fun readFloat(): Float = 1f

    actual fun readDouble(): Double = 1.0

    actual fun writeByte(value: Byte) {
    }

    actual fun writeInt(value: Int) {
    }

    actual fun writeFloat(value: Float) {
    }

    actual fun writeDouble(value: Double) {
    }

    actual fun writeString(value: String?) {
    }
}