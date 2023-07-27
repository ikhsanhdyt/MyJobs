package com.diavolo.myjobs.data.local.preference.datasource

import com.diavolo.myjobs.data.local.preference.SessionPreference
import com.diavolo.myjobs.data.network.model.response.User
import javax.inject.Inject


class LocalDataSourceImpl
@Inject constructor(private val sessionPreference: SessionPreference) : LocalDataSource {
    override fun getAuthToken(): String? {
        return sessionPreference.authToken
    }

    override fun setAuthToken(authToken: String?) {
        sessionPreference.authToken = authToken
    }

    override fun isUserLoggedIn(): Boolean {
        return !sessionPreference.authToken.isNullOrEmpty()
    }

    override fun saveUserData(user: User) {
        sessionPreference.user = user
    }

    override fun getUserData(): User? {
        return sessionPreference.user
    }

    override fun clearSession() {
        sessionPreference.deleteSession()
    }
}