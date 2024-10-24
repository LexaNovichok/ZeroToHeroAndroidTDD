package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel

interface ProvideViewModel {
    fun <T : ViewModel> viewModel(viewModelClass : Class<T>) : T

    class Base(
        private val clearViewModel : ClearViewModel,
        core : Core
    ) : ProvideViewModel {
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when(viewModelClass) {

                else -> throw IllegalStateException("unknown viewModelClass $viewModelClass")
            }  as T
        }
    }
}