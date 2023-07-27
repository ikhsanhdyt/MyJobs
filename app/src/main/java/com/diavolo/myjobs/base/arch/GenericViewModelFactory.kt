package com.diavolo.myjobs.base.arch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

/**
 * Written with passion by Ikhsan Hidayat on 15/07/2023.
 */
class GenericViewModelFactory(private val viewModel: ViewModel) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(viewModel::class.java)){
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown Class Name")
    }
}