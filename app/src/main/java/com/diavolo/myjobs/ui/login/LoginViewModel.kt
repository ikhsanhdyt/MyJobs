package com.diavolo.myjobs.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.diavolo.myjobs.base.arch.BaseViewModelImpl
import com.diavolo.myjobs.base.model.Resource
import com.diavolo.myjobs.data.network.model.response.User
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Written with passion by Ikhsan Hidayat on 15/07/2023.
 */
@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) :
    BaseViewModelImpl(), LoginContract.ViewModel {

    private val signInResponseLiveData = MutableLiveData<Resource<User>>()

    override fun getUserLiveData(): LiveData<Resource<User>> = signInResponseLiveData


    override fun signInGoogle(idToken: String,email:String) {
        signInResponseLiveData.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.signIn(idToken,email)
                viewModelScope.launch(Dispatchers.Main) {
                    signInResponseLiveData.value = Resource.Success(response)
                }
            } catch (e: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    signInResponseLiveData.value = Resource.Error(e.message.orEmpty())
                }
            }
        }
    }

}