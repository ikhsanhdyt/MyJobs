package com.diavolo.myjobs.di

import com.diavolo.myjobs.base.arch.GenericViewModelFactory
import com.diavolo.myjobs.ui.login.LoginRepository
import com.diavolo.myjobs.ui.login.LoginViewModel
import com.diavolo.myjobs.ui.splash.SplashRepository
import com.diavolo.myjobs.ui.splash.SplashViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

/**
 * Written with passion by Ikhsan Hidayat on 16/07/2023.
 */
@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {

    @Provides
    @ActivityScoped
    fun provideLoginViewModel(
        loginRepository: LoginRepository
    ): LoginViewModel {
        return GenericViewModelFactory(LoginViewModel(loginRepository)).create(
            LoginViewModel::class.java
        )
    }

    @Provides
    @ActivityScoped
    fun provideSplashViewModel(
        splashRepository: SplashRepository
    ): SplashViewModel {
        return GenericViewModelFactory(SplashViewModel(splashRepository)).create(
            SplashViewModel::class.java
        )
    }

}