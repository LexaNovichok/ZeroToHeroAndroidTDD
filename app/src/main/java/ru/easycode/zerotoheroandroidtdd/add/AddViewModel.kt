package ru.easycode.zerotoheroandroidtdd.add

import ru.easycode.zerotoheroandroidtdd.core.Repository
import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper

class AddViewModel(
    private val repository : Repository.Add,
    private val liveDataWrapper : ListLiveDataWrapper.Add,

) {
}