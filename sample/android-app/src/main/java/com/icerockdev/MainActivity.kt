/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.icerockdev.library.User

class MainActivity : AppCompatActivity() {

    private val userInstanceKey = "user"
    private var user: User = User(
        firstName = "Aleksey",
        lastName = "Mikhailov",
        phone = "+79000000000",
        age = 26
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putParcelable(userInstanceKey, user)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState?.getParcelable<User>(userInstanceKey)?.let {
            this.user = it
        }
    }
}
