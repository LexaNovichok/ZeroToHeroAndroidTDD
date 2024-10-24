package ru.easycode.zerotoheroandroidtdd.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.Navigation
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListScreen

class MainViewModel(
    private val navigation : Navigation.Mutable
) : ViewModel(), Navigation.Read {

    fun init() {
        navigation.update(ListScreen)
    }

    override fun liveData(): LiveData<Screen> = navigation.liveData()
}