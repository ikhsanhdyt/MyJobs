package com.diavolo.myjobs.data.network.datasource

import com.diavolo.myjobs.data.network.model.response.User

/**
 * Written with passion by Ikhsan Hidayat on 26/07/2023.
 */
interface AuthDataSource {
    suspend fun getUser(idToken: String): User
}