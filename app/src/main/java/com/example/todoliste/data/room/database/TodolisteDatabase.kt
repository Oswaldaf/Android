package com.example.todoliste.data.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoliste.data.room.daos.OTPCodeDao
import com.example.todoliste.data.room.daos.UserDao
import com.example.todoliste.data.room.models.OTPCode
import com.example.todoliste.data.room.models.User

@Database(
    entities = [User::class, OTPCode::class],
    version = 2,
    exportSchema = false
)
abstract class TodolisteDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun otpCodeDao(): OTPCodeDao

    companion object {
        @Volatile
        var INSTANCE: TodolisteDatabase? = null
        fun getDatabase(context: Context): TodolisteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context = context,
                    TodolisteDatabase::class.java,
                    name = "todoliste_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance

                return instance
            }
        }
    }
}