package com.diavolo.myjobs.base.arch

import timber.log.Timber


/**
 * Written with passion by Ikhsan Hidayat on 15/07/2023.
 */
open class BaseRepositoryImpl : BaseContract.BaseRepository {
    override fun logResponse(msg: String?) {
        Timber.tag(BaseRepositoryImpl::class.java.simpleName).d(msg.orEmpty())
    }
}