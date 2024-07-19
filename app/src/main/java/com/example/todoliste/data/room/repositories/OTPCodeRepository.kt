package com.example.todoliste.data.room.repositories

import com.example.todoliste.data.room.daos.OTPCodeDao
import com.example.todoliste.data.room.daos.UserDao
import com.example.todoliste.data.room.models.OTPCode
import kotlinx.coroutines.flow.Flow

class OTPCodeRepository (
    private val otpCodeDao: OTPCodeDao
) {
    suspend fun insert(otpCode: OTPCode) { otpCodeDao.insert(otpCode) }
    fun checkOtpCode(email: String, code: String): Flow<List<OTPCode>> = otpCodeDao.checkOtpCode(email, code)
}