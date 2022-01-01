package com.sr.dicepractice.screens.roll

import androidx.lifecycle.*
import com.sr.dicepractice.appconstants.Constants.LOG_APP_NAME
import timber.log.Timber
import java.util.*

class ViewModelRoll : ViewModel() {

    private val _rollValue = MutableLiveData(0)

    val rollValueInt: LiveData<Int>
        get() = _rollValue

    val rollValueString = Transformations.map(rollValueInt) {
        it?.let {
            if (it > 0) it.toString() else "Welcome!"
        } ?: kotlin.run {
            "Welcome!"
        }
    }

    init {
        Timber.d(" :$LOG_APP_NAME: ViewModelRoll: :init: ")
    }

    fun onClickRoll() {
        Timber.d(" :$LOG_APP_NAME: ViewModelRoll: :onClickRoll: ")
         val random = Random().nextInt(6) + 1
        _rollValue.value = random
    }

    override fun onCleared() {
        Timber.d(" :$LOG_APP_NAME: ViewModelRoll: :onCleared: ")
        super.onCleared()
    }
}