package com.diavolo.myjobs.base.model

/**
 * Written with passion by Ikhsan Hidayat on 15/07/2023.
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)

    class Loading<T>(data: T? = null) : Resource<T>(data)

    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}