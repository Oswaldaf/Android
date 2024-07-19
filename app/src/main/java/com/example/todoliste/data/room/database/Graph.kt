package com.example.todoliste.data.room.database

import android.content.Context
import com.example.todoliste.data.room.repositories.OTPCodeRepository
import com.example.todoliste.data.room.repositories.UserRepository

object Graph {
    private lateinit var todolisteDatabase: TodolisteDatabase
        private set

    val userRepository by lazy {
        UserRepository(
            userDao = todolisteDatabase.userDao()
        )
    }

    val otpCodeRepository by lazy {
        OTPCodeRepository(
            otpCodeDao = todolisteDatabase.otpCodeDao()
        )
    }
    fun provide(context: Context) {
        todolisteDatabase = TodolisteDatabase.getDatabase(context = context)
    }
}