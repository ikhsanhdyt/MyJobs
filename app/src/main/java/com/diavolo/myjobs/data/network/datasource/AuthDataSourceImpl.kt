package com.diavolo.myjobs.data.network.datasource

import com.diavolo.myjobs.data.network.model.response.User
import javax.inject.Inject

/**
 * Written with passion by Ikhsan Hidayat on 27/07/2023.
 */
class AuthDataSourceImpl @Inject constructor() :
    AuthDataSource {
    override suspend fun getUser(idToken: String): User {
        // Simulate a successful Google Sign-In for demonstration purposes
        // Replace this with actual Google Sign-In implementation using Firebase Authentication
        val user = User("john.doe@example.com")
        return user
    }


}