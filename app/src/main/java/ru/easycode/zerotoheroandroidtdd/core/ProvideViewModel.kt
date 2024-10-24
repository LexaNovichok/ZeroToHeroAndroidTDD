package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel

interface ProvideViewModel {

    fun <T : ViewModel> viewModel(viewModelClass : Class<T>) : T

    class Base(
        private val clearViewModel : ClearViewModel,
        core : Core
    ) : ProvideViewModel {

        private val navigation = Navigation.Base()

        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when(viewModelClass) {
                MainViewModel::class.java -> MainViewModel(navigation)
                else -> throw IllegalStateException("unknown viewModelClass $viewModelClass")
            }  as T
        }
    }
}