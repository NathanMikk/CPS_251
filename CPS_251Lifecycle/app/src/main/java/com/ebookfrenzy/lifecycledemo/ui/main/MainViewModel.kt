package com.ebookfrenzy.lifecycledemo.ui.main

import android.icu.util.TimeZone.SystemTimeZoneType
import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

     companion object{
         private var data: MutableLiveData<String> = MutableLiveData()
         private var continualData: MutableLiveData<String> = MutableLiveData()

         fun status(value:String) {
             data.value = "********************" + "\n" + value +" "+ java.time.LocalTime.now()
             if (continualData.value != null) {
                 continualData.value = continualData.value + data.value + "\n"
             } else {
                 continualData.value = data.value + "\n"
             }
         }
     }

     fun getStatus(): MutableLiveData<String>{
        return continualData
     }
}