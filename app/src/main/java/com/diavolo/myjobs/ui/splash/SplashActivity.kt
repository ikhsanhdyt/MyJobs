package com.diavolo.myjobs.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import com.diavolo.myjobs.base.arch.BaseActivity
import com.diavolo.myjobs.databinding.ActivitySplashBinding
import com.diavolo.myjobs.ui.home.HomeActivity
import com.diavolo.myjobs.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity :
    BaseActivity<ActivitySplashBinding, SplashViewModel>(ActivitySplashBinding::inflate),
    SplashContract.View {
    private val timer: CountDownTimer by lazy {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                checkLoginStatus()
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSplashTimer()
    }

    private fun setSplashTimer() {
        timer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    override fun initView() {}

    override fun checkLoginStatus() {
        if (getViewModel().isUserLoggedIn()) {
            navigateToHome()
        } else {
            navigateToLogin()
        }
    }

    override fun deleteSession() {
        getViewModel().clearSession()
    }

    override fun navigateToLogin() {
        LoginActivity.startActivity(this)
    }

    override fun navigateToHome() {
        HomeActivity.startActivity(this)
    }
}