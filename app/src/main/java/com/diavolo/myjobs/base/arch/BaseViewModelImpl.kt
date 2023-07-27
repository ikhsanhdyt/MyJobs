package com.diavolo.myjobs.base.arch

import androidx.lifecycle.ViewModel
import timber.log.Timber


/**
 * Written with passion by Ikhsan Hidayat on 15/07/2023.
 */
open class BaseViewModelImpl : ViewModel(), BaseContract.BaseViewModel {
    override fun logResponse(msg: String?) {
        Timber.tag(BaseViewModelImpl::class.java.simpleName).d(msg.orEmpty())
    }
}