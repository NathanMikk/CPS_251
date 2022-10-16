package com.example.addnameproject.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var nameText = ""

    fun setResult(value:String){
        if(nameText.isBlank()){
            this.nameText = value
        }else{
            this.nameText = nameText + "\n"+ value
        }
    }
    fun getResult():String{
        return nameText
    }

}