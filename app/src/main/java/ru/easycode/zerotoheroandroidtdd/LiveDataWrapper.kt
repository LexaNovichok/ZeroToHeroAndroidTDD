package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    fun save(bundleWrapper: BundleWrapper.Save)
    fun update(value: UiState)
    fun liveData() : LiveData<UiState>

    class Base(
        private val liveData : SingleLiveEvent<UiState> = SingleLiveEvent()
    ) : LiveDataWrapper {
        override fun liveData(): LiveData<UiState> = liveData
        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
        }
        override fun update(value: UiState) {
            liveData.value = value
        }

    }
}

