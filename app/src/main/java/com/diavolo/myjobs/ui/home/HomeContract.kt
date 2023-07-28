package com.diavolo.myjobs.ui.home

import androidx.lifecycle.LiveData
import com.diavolo.myjobs.base.arch.BaseContract
import com.diavolo.myjobs.base.model.Resource
import com.diavolo.myjobs.data.network.model.response.User

/**
 * Written with passion by Ikhsan Hidayat on 27/07/2023.
 */
interface HomeContract {

    interface View : BaseContract.BaseView {
        fun getData()
        fun setContentData(user: User)
        fun setBindingClickListeners()
        fun showLogoutConfirmation()
        fun logout()
        fun navigateToLogin()
    }

    interface ViewModel : BaseContract.BaseViewModel {
        fun getAccountLiveData(): LiveData<Resource<User>>
        fun getAccountData()
        fun logout()
    }

    interface Repository : BaseContract.BaseRepository {
        suspend fun getAccountData() : User?

        fun clearSession()
    }

}