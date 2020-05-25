package com.pessoadev.radicalizeapp.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

open class BaseViewModel : ViewModel() {
    val scope = CoroutineScope(
        Job() + Dispatchers.Main
    )

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }

//    fun getError(e: Exception) : ErrorModel{
//        return ApiErrorHandle.traceErrorException(e)
//    }

//    fun <T> MutableLiveData<T>.notifyObserver() {
//        this.value = this.value
//    }

}