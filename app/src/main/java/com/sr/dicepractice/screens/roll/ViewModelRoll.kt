package com.sr.dicepractice.screens.roll

import androidx.lifecycle.*
import com.sr.dicepractice.appconstants.Constants.LOG_APP_NAME
import timber.log.Timber
import java.util.*

class ViewModelRoll : ViewModel() {

    private val _rollValue = MutableLiveData(0)

    private val rollValueInt: LiveData<Int>
        get() = _rollValue

    /**
     * 1/24/2022 05:40
     * <p>
     * [rollValueString] is a normal [String]. However, its value
     * keeps changing in sync with [rollValueInt] which is a [LiveData]
     * and [rollValueInt] gets update via [_rollValue] which is a
     * [MutableLiveData].
     * </p>
     * [_rollValue] is being updated at [onClickRoll] and [onClickReset].
     * Update in [_rollValue] will update [rollValueInt] which is a [LiveData].
     * </p>
     * An update in [rollValueInt] will notify all the observers about the update.
     * </p>
     *
     * @author srdpatel
     * @since v0.0.1
     */
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

    fun onClickReset() {
        Timber.d(" :$LOG_APP_NAME: ViewModelRoll: :onClickReset: ")
        _rollValue.value = 0
    }

    override fun onCleared() {
        Timber.d(" :$LOG_APP_NAME: ViewModelRoll: :onCleared: ")
        super.onCleared()
    }
}