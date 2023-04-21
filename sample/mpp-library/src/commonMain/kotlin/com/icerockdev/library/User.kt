/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev.library

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import dev.icerock.moko.parcelize.TypeParceler
import kotlinx.datetime.LocalDateTime

@Parcelize
data class User(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val age: Int,
    @TypeParceler<LocalDateTime, LocalDateTimeParceler>()
    val birthday : LocalDateTime
) : Parcelable
