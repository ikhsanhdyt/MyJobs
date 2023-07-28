package com.diavolo.myjobs.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.diavolo.myjobs.base.arch.BaseViewModelImpl
import com.diavolo.myjobs.base.model.Resource
import com.diavolo.myjobs.data.network.model.response.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Written with passion by Ikhsan Hidayat on 27/07/2023.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) :
    BaseViewModelImpl(), HomeContract.ViewModel {

    private val getAccountResponseLiveData = MutableLiveData<Resource<User>>()

    override fun getAccountLiveData(): LiveData<Resource<User>> = getAccountResponseLiveData

    override fun getAccountData() {
        getAccountResponseLiveData.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getAccountData()
                viewModelScope.launch(Dispatchers.Main){
                    getAccountResponseLiveData.value = Resource.Success(response!!)
                }
            }catch (e:Exception){
                viewModelScope.launch(Dispatchers.Main) {
                    getAccountResponseLiveData.value = Resource.Error(e.message.orEmpty())
                }
            }
        }
    }

    override fun logout() {
        repository.clearSession()
    }
}