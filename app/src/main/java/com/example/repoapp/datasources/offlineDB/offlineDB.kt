package com.example.repoapp.datasources.offlineDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.repoapp.model.NightLifeModel


@Database(entities = [NightLifeModel::class], version = 1)
abstract class offlineDB  : RoomDatabase() {
    abstract fun nightLifeDAO(): offlineDAO
}