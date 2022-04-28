package com.shubham.jetpackcomponent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val mutableLiveData = MutableLiveData<String>("Starting value")

    fun updateData(){
        mutableLiveData.value = "data changed"
    }

}