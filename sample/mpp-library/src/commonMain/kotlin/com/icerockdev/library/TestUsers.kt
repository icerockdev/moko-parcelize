package com.icerockdev.library

import kotlinx.datetime.LocalDateTime

object TestUsers {
    val user: User = User(
        firstName = "Aleksey",
        lastName = "Mikhailov",
        phone = "+79000000000",
        age = 26,
        birthday = LocalDateTime(1970, 1, 1, 0, 0, 0, 0)
    )
}