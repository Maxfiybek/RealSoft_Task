package com.example.realsofttask.domain.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.realsofttask.utils.DataBase

@Entity(tableName = "tokens")
data class TokenEntity(
    @PrimaryKey val token: String
)
