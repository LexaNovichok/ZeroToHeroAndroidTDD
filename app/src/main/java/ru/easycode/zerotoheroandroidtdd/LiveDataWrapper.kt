package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Update {
        fun update(list : ArrayList<String>)
    }

    interface Observe {
        fun liveData() : LiveData<ArrayList<String>>
    }

    interface Mutable : Save, Update, Observe

    class Base(
        private val liveData : MutableLiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>()
    ) : Mutable {
        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let {
                bundleWrapper.save(it)
            }
        }

        override fun update(list: ArrayList<String>) {
            liveData.value = list
        }

        override fun liveData(): LiveData<ArrayList<String>> = liveData

    }
}