package ru.easycode.zerotoheroandroidtdd.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListScreen

class MainViewModel(
    private val navigation : Navigation.Mutable
) : ViewModel(), Navigation.Read {

    init {
        Log.d("LALALA", "MainViewModel init")
    }
    override fun liveData(): LiveData<Screen> = navigation.liveData()

    fun init(firstRun : Boolean) {
        if (firstRun)
            navigation.update(ListScreen)
    }
}