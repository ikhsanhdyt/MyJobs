package com.diavolo.myjobs.di

import com.diavolo.myjobs.data.local.preference.SessionPreference
import com.diavolo.myjobs.data.local.preference.datasource.LocalDataSource
import com.diavolo.myjobs.data.local.preference.datasource.LocalDataSourceImpl
import com.diavolo.myjobs.data.network.datasource.AuthDataSource
import com.diavolo.myjobs.data.network.datasource.AuthDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Written with passion by Ikhsan Hidayat on 15/07/2023.
 */
@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    @Provides
    fun provideGoogleDataSource(): AuthDataSource {
        return AuthDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(sessionPreference: SessionPreference): LocalDataSource {
        return LocalDataSourceImpl(sessionPreference)
    }
}