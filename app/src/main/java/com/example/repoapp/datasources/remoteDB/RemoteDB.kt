package com.example.repoapp.datasources.remoteDB

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDB {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://661e8fe198427bbbef04f98c.mockapi.io/") // Base URL of the mock API
        .addConverterFactory(GsonConverterFactory.create()) // Gson converter for parsing JSON response
        .build()
    @Provides
    @Singleton
    fun nightlifeDao(): NightlifeDAO = retrofit.create(NightlifeDAO::class.java)

}