package com.example.realsofttask.data.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.realsofttask.domain.models.entity.TokenEntity

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveToken(token: TokenEntity)

    @Query("SELECT token FROM tokens")
    suspend fun getToken(): String?
}