package com.example.realsofttask.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.realsofttask.domain.models.entity.TokenEntity

@Database(entities = [TokenEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun appDao(): AppDao
}