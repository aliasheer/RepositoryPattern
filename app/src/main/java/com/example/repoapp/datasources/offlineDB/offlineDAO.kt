package com.example.repoapp.datasources.offlineDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.repoapp.model.NightLifeModel


@Dao
interface offlineDAO {

    @Query("SELECT * FROM NightLifeModel")
    suspend fun getNightLife(): List<NightLifeModel>

    @Insert
    suspend fun insertNightLife(nightLifeModel: List<NightLifeModel>)
}