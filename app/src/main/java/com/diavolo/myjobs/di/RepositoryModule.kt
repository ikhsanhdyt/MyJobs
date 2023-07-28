package com.diavolo.myjobs.di

import com.diavolo.myjobs.data.local.preference.datasource.LocalDataSource
import com.diavolo.myjobs.ui.home.HomeRepository
import com.diavolo.myjobs.ui.login.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Written with passion by Ikhsan Hidayat on 16/07/2023.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideLoginRepository(
        localDataSource: LocalDataSource
    ): LoginRepository {
        return LoginRepository(localDataSource)
    }

    @Provides
    @Singleton
    fun provideHomeRepository(
        localDataSource: LocalDataSource
    ): HomeRepository {
        return HomeRepository(localDataSource)
    }
}