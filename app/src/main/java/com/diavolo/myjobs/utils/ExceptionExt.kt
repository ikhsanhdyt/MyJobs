package com.diavolo.myjobs.utils

import android.content.Context
import com.diavolo.myjobs.R
import com.diavolo.myjobs.exception.ApiErrorException
import com.diavolo.myjobs.exception.NoInternetConnectionException

fun Context.getErrorMessage(exception : Exception): String {
    return when (exception) {
        is NoInternetConnectionException -> getString(R.string.error_message_no_internet)
        is ApiErrorException -> exception.message.orEmpty()
        else -> getString(R.string.error_message_unknown)
    }
}