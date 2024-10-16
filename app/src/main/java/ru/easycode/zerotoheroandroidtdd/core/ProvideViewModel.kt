package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.AddViewModel

interface ProvideViewModel {
    fun <T : ViewModel> viewModel(viewModelClass : Class<T>) : T

    class Base(
        private val clearViewModel: ClearViewModel
    ) : ProvideViewModel {
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when(viewModelClass) {

                    AddViewModel::class.java -> AddViewModel()
                else -> throw  IllegalStateException("unknown viewModelClass $viewModelClass")
            } as T
        }

    }

}