package com.example.addnameproject.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.databinding.ViewDataBinding

class MainViewModel : ViewModel() {
    var nameText: MutableLiveData<String> = MutableLiveData()
    var result: MutableLiveData<String> = MutableLiveData()

    fun convertValue(){
        nameText.let{
            if(!it.value.isNullOrEmpty()){
                if(result.value == null) {
                    result.value = it.value
                }else{
                    result.value = it.value + "\n" + result.value
                }
            } else{
                result.value = "No name entered"
            }
        }
    }
}