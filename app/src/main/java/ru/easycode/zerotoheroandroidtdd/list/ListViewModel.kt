package ru.easycode.zerotoheroandroidtdd.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.add.AddScreen
import ru.easycode.zerotoheroandroidtdd.core.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.core.Repository
import ru.easycode.zerotoheroandroidtdd.main.Navigation

class ListViewModel(
    private val repository : Repository.Read,
    private val listLiveDataWrapper : ListLiveDataWrapper.Mutable,
    private val navigation : Navigation.Mutable,
    private val dispatcher : CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherMain : CoroutineDispatcher = Dispatchers.Main
) : ViewModel(), LiveDataWrapper.Read<List<String>> {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun addFragment() {
        navigation.update(AddScreen)
    }

    fun init() {
        viewModelScope.launch(dispatcher) {
            val value = repository.list()
            listLiveDataWrapper.update(value)
        }
    }

    override fun liveData(): LiveData<List<String>> = listLiveDataWrapper.liveData()


}