package com.diavolo.myjobs.data.local.preference.datasource

import com.diavolo.myjobs.data.network.model.response.User

interface LocalDataSource {
    fun getAuthToken(): String?
    fun setAuthToken(authToken: String?)
    fun isUserLoggedIn(): Boolean
    fun saveUserData(user: User)
    fun getUserData(): User?
    fun clearSession()
}