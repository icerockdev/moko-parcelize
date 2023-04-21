/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.parcelize

expect annotation class Parcelize()

expect interface Parcelable

expect annotation class IgnoredOnParcel()

expect interface Parceler<P> {
    fun create(parcel: Parcel): P

    fun P.write(parcel: Parcel, flags: Int)
}

expect annotation class TypeParceler<T, P : Parceler<in T>>()

expect class Parcel {
    fun readByte(): Byte
    fun readInt(): Int

    fun readFloat(): Float
    fun readDouble(): Double
    fun readString(): String?

    fun writeByte(value: Byte)
    fun writeInt(value: Int)

    fun writeFloat(value: Float)

    fun writeDouble(value: Double)
    fun writeString(value: String?)


}