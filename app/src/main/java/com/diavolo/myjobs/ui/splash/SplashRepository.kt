package com.diavolo.myjobs.ui.splash

import com.diavolo.myjobs.base.arch.BaseRepositoryImpl
import com.diavolo.myjobs.data.local.preference.datasource.LocalDataSource
import javax.inject.Inject

class SplashRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) : BaseRepositoryImpl(), SplashContract.Repository {

    override fun isUserLoggedIn(): Boolean {
        return localDataSource.isUserLoggedIn()
    }

    override fun clearSession() {
        localDataSource.clearSession()
    }
}