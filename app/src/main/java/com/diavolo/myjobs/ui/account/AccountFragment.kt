package com.diavolo.myjobs.ui.account

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.diavolo.myjobs.R
import com.diavolo.myjobs.base.arch.BaseFragment
import com.diavolo.myjobs.base.model.Resource
import com.diavolo.myjobs.data.network.model.response.User
import com.diavolo.myjobs.databinding.FragmentAccountBinding
import com.diavolo.myjobs.ui.home.HomeContract
import com.diavolo.myjobs.ui.home.HomeViewModel
import com.diavolo.myjobs.ui.login.LoginActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment :
    BaseFragment<FragmentAccountBinding, HomeViewModel>(FragmentAccountBinding::inflate),
    HomeContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()
    }


    override fun initView() {
        setBindingClickListeners()

    }

    override fun getData() {
        getViewModel().getAccountData()
    }


    override fun observeData() {
        super.observeData()
        getViewModel().getAccountLiveData().observe(this) {
            when (it) {
                is Resource.Loading -> {

                }

                is Resource.Success -> {
                    setContentData(it.data!!)
                }

                is Resource.Error -> {

                }
            }
        }
    }

    override fun setContentData(user: User) {
        getViewBinding().tvUserFullName.text = user.email
    }

    override fun setBindingClickListeners() {
        getViewBinding().btnLogout.setOnClickListener{
            showLogoutConfirmation()
        }
    }

    override fun showLogoutConfirmation() {
        MaterialAlertDialogBuilder(requireContext())
            .apply {
                setTitle(getString(R.string.account_dialog_logout_title))
                    .setMessage(getString(R.string.account_dialog_logout_message))
                    .setPositiveButton(getString(R.string.account_btn_logout)) { dialog, _ ->
                        logout()
                        dialog.dismiss()
                    }
                    .setNegativeButton(getString(R.string.dialog_cancel)) { dialog, _ ->
                        dialog.dismiss()
                    }
            }.create().show()
    }

    override fun logout() {
        getViewModel().logout()
        Toast.makeText(requireContext(), getString(R.string.toast_logout_successful), Toast.LENGTH_SHORT).show()
        navigateToLogin()
    }

    override fun navigateToLogin() {
        LoginActivity.startActivity(requireContext())
    }

    override fun showContent(isVisible: Boolean) {
        super.showContent(isVisible)
    }

    override fun showLoading(isVisible: Boolean) {
        super.showLoading(isVisible)
    }

    override fun showError(isErrorEnabled: Boolean, msg: String?) {
        super.showError(isErrorEnabled, msg)
    }
}