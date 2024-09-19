package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    class Base(
        private val liveData: MutableLiveData<UiState> = MutableLiveData()) : LiveDataWrapper {
        private val actualCallsList = mutableListOf<UiState>()

        fun checkUpdateCalls(expected : List<UiState>) {
            liveData.value = actualCallsList[actualCallsList.size - 1]
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> = liveData

    }
}
