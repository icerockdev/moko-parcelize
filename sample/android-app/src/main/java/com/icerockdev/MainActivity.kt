/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package com.icerockdev

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.icerockdev.library.TestUsers
import com.icerockdev.library.User
import kotlinx.datetime.LocalDateTime

class MainActivity : AppCompatActivity() {

    private val userInstanceKey = "user"
    private var user: User = TestUsers.user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(userInstanceKey, user)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState.getParcelable<User>(userInstanceKey)?.let {
            Log.d("MainActivity", "Read user: $it")
            this.user = it
        }
    }
}
