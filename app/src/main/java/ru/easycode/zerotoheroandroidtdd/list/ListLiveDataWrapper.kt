package ru.easycode.zerotoheroandroidtdd.list

import androidx.lifecycle.LiveData
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.db.ItemCache

interface ListLiveDataWrapper {

    interface Read {
        fun liveData() : LiveData<List<ItemCache>>
    }

    interface Update {
        fun update(value : List<ItemCache>)
    }

    interface Mutable : Read, Update

    interface Add {
        fun add(value : ItemCache)
    }

    interface All : Mutable, Add

    class Base : LiveDataWrapper.AbstractLiveData<List<ItemCache>>(), All {

        override fun add(value: ItemCache) {
            val currentList = liveData.value?.toMutableList() ?: ArrayList()
            currentList.add(value)
            update(currentList)
        }

    }
}