package com.oscargil80.roomexampleappdevsnotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oscargil80.roomexampleappdevsnotes.db.SubscriberRepository

class SubscriberViewModelFactory(private val repository: SubscriberRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubscriberViewModel::class.java)){
            return  SubscriberViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown View Model Class")
    }
}