package ru.easycode.zerotoheroandroidtdd.list

import androidx.lifecycle.LiveData
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper

interface ListLiveDataWrapper {

    interface Read {
        fun liveData() : LiveData<List<String>>
    }

    interface Update {
        fun update(value: List<String>)
    }
    interface Mutable : Read, Update

    interface Add {
        fun add(value : String)
    }

    interface All : Mutable, Add
    class Base : LiveDataWrapper.Abstract<List<String>>(), All {

        override fun add(value : String) {
            val currentList = liveData.value?.toMutableList() ?: ArrayList()
            currentList.add(value)
            update(currentList)
        }
    }

}