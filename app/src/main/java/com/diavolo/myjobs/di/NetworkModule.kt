package com.diavolo.myjobs.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.diavolo.myjobs.data.network.services.DansJobsApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Written with passion by Ikhsan Hidayat on 16/07/2023.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideDansJobsApiServices(chuckerInterceptor : ChuckerInterceptor): DansJobsApiServices {
        return DansJobsApiServices.invoke(chuckerInterceptor)
    }

    @Singleton
    @Provides
    fun provideChuckerInterceptor(@ApplicationContext context : Context) : ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context).build()
    }

}