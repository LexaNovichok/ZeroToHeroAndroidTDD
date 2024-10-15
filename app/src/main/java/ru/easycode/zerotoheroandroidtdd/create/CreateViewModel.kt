package ru.easycode.zerotoheroandroidtdd.create

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.ClearViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.main.Navigation
import ru.easycode.zerotoheroandroidtdd.main.Screen

class CreateViewModel(
    private val addLiveDataWrapper: ListLiveDataWrapper.Add,
    private val navigation: Navigation.Update,
    private val clearViewModel: ClearViewModel
) : ViewModel() {

    init {
        Log.d("LALALA", "CreateViewModel init")
    }

    fun add(text : CharSequence) {
        addLiveDataWrapper.add(text)
        comeback()
    }

    fun comeback() {
        navigation.update(Screen.Pop)
        clearViewModel.clear(CreateViewModel::class.java)
    }
}