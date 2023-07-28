package com.diavolo.myjobs.ui.login

import com.diavolo.myjobs.base.arch.BaseRepositoryImpl
import com.diavolo.myjobs.data.local.preference.datasource.LocalDataSource
import com.diavolo.myjobs.data.network.model.response.User
import javax.inject.Inject

/**
 * Written with passion by Ikhsan Hidayat on 15/07/2023.
 */
class LoginRepository
@Inject constructor(
    private val localDataSource: LocalDataSource
) : BaseRepositoryImpl(), LoginContract.Repository {

    override suspend fun signIn(idToken: String, email: String): User {
        localDataSource.setAuthToken(idToken)
        localDataSource.saveUserData(User(email = email))
        return User(email = email)
    }

}