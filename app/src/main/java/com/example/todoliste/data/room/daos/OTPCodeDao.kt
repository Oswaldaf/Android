package com.example.todoliste.data.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todoliste.data.room.models.OTPCode
import kotlinx.coroutines.flow.Flow

@Dao
interface OTPCodeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(otpCode: OTPCode)

    @Query("SELECT * FROM otp_codes WHERE email =:email AND code =:code")
    fun checkOtpCode(email: String, code: String): Flow<List<OTPCode>>

}