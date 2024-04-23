package com.example.repoapp.di

import android.app.Application
import com.example.repoapp.utils.NetworkStatusChecker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkStatusChecker(application: Application): NetworkStatusChecker {
        return NetworkStatusChecker(application)
    }
}