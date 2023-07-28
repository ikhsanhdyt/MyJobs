package com.diavolo.myjobs.ui.home

import com.diavolo.myjobs.base.arch.BaseRepositoryImpl
import com.diavolo.myjobs.data.local.preference.datasource.LocalDataSource
import com.diavolo.myjobs.data.network.model.response.User
import javax.inject.Inject

/**
 * Written with passion by Ikhsan Hidayat on 27/07/2023.
 */
class HomeRepository @Inject constructor(private val localDataSource: LocalDataSource) :
    BaseRepositoryImpl(),
    HomeContract.Repository {
    override suspend fun getAccountData(): User? {
        return localDataSource.getUserData()
    }

    override fun clearSession() {
        return localDataSource.clearSession()
    }

}