package com.example.repoapp.datasources.offlineDB

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object offlineDBRoom {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): offlineDB {
        return Room
            .databaseBuilder(appContext, offlineDB::class.java, "offlineDB")
            .build()
    }

    @Singleton
    @Provides
    fun provideOfflineDAO(db: offlineDB): offlineDAO {
        return db.nightLifeDAO()
    }
}