package com.icerockdev.library

import dev.icerock.moko.parcelize.Parcel
import dev.icerock.moko.parcelize.Parceler
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toLocalDateTime

object LocalDateTimeParceler :
    Parceler<LocalDateTime> {
    override fun create(parcel: Parcel): LocalDateTime {
        val date = parcel.readString()
        return date?.toLocalDateTime()
            ?: LocalDateTime(0, 0, 0, 0, 0)
    }

    override fun LocalDateTime.write(parcel: Parcel, flags: Int) {
        parcel.writeString(this.toString())
    }
}