package com.pessoadev.radicalizeapp.presentation.main.presentation

import androidx.lifecycle.MutableLiveData
import com.pessoadev.radicalizeapp.presentation.base.BaseViewModel
import com.pessoadev.radicalizeapp.presentation.main.data.MainRepository
import com.pessoadev.radicalizeapp.presentation.main.model.Activities
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repository: MainRepository) : BaseViewModel() {

    val activities = MutableLiveData<MutableList<Activities>>()

    fun getActivitiesByState(state : String) {
        scope.launch {
            try {
                val activitiesList = mutableListOf<Activities>()
                repository.getActivitiesByCity(state)
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            activitiesList.add(document.toObject(Activities::class.java))
                        }
                        activities.value = activitiesList
                    }.addOnFailureListener { e ->
                        e.printStackTrace()
                        activities.value = mutableListOf()
                    }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}