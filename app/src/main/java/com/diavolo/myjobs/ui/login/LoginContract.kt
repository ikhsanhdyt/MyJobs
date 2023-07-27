package com.diavolo.myjobs.ui.login

import androidx.lifecycle.LiveData
import com.diavolo.myjobs.base.arch.BaseContract
import com.diavolo.myjobs.base.model.Resource
import com.diavolo.myjobs.data.network.model.response.User

/**
 * Written with passion by Ikhsan Hidayat on 15/07/2023.
 */
interface LoginContract {
    interface View : BaseContract.BaseView {
    }

    interface ViewModel : BaseContract.BaseViewModel {
        fun getUserLiveData(): LiveData<Resource<User>>
        fun signInGoogle(idToken: String, email: String)
    }

    interface Repository : BaseContract.BaseRepository {
        suspend fun signIn(idToken: String, email: String): User
    }
}