package com.example.repoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "NightLifeModel")
data class NightLifeModel( @PrimaryKey(autoGenerate = true)
                           val id: Int=0,
                           @ColumnInfo(name = "name")
                           val name: String?,
                           @ColumnInfo(name = "image")
                           val image: String?,
    // Add additional columns as needed
                           @ColumnInfo(name = "createdAt")
                           val createdAt: String)
