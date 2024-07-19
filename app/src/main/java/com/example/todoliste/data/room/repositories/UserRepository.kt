package com.example.todoliste.data.room.repositories

import com.example.todoliste.data.room.daos.UserDao
import com.example.todoliste.data.room.models.User
import kotlinx.coroutines.flow.Flow

class UserRepository (
    private val userDao: UserDao
) {
    val usersList = userDao.usersList()

    suspend fun register(user: User) { userDao.register(user) }

    fun getUserByEmail(email: String): Flow<List<User>> = userDao.getUserByEmail(email)
    fun activateUserByEmail(email: String) = userDao.activateUserByEmail(email)
}