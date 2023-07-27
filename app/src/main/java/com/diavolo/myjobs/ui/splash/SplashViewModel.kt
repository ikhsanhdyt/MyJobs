package com.diavolo.myjobs.ui.splash

import com.diavolo.myjobs.base.arch.BaseViewModelImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: SplashRepository) :
    BaseViewModelImpl(), SplashContract.ViewModel {

    override fun isUserLoggedIn(): Boolean {
        return repository.isUserLoggedIn()
    }

    override fun clearSession() {
        repository.clearSession()
    }
}