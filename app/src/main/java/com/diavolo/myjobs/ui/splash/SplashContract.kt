package com.diavolo.myjobs.ui.splash

import com.diavolo.myjobs.base.arch.BaseContract

interface SplashContract {
    interface View : BaseContract.BaseView {
        fun checkLoginStatus()
        fun deleteSession()
        fun navigateToLogin()
        fun navigateToHome()
    }

    interface ViewModel : BaseContract.BaseViewModel{
        fun isUserLoggedIn(): Boolean
        fun clearSession()
    }

    interface Repository : BaseContract.BaseRepository{
        fun isUserLoggedIn(): Boolean
        fun clearSession()
    }
}