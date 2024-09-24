package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository) : ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            repository.load()

            liveDataWrapper.update(UiState.ShowData)
        }
    }

    fun setCurrentState() {
        val currentState = liveDataWrapper.liveData().value
        if (currentState != null) {
            liveDataWrapper.update(currentState)
            Log.d("LALALA", "Current state is $currentState")
        } else {
            liveDataWrapper.update(UiState.Initial)
            Log.d("LALALA", "Initial state")
        }
    }

    fun liveData() = liveDataWrapper.liveData()
}