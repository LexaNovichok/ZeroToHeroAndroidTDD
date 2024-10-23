package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.add.AddViewModel
import ru.easycode.zerotoheroandroidtdd.list.ListLiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.list.ListViewModel
import ru.easycode.zerotoheroandroidtdd.main.MainViewModel
import ru.easycode.zerotoheroandroidtdd.main.Navigation

interface ProvideViewModel {
    fun <T : ViewModel> viewModel(viewModelClass : Class<T>) : T

    class Base(
        private val clearViewModel: ClearViewModel,
        core: Core
    ) : ProvideViewModel {

        private val repository = Repository.Base(core.dao(), Now.Base())
        private val listLiveDataWrapper = ListLiveDataWrapper.Base()
        private val navigation = Navigation.Base()
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            return when(viewModelClass) {
                MainViewModel::class.java -> MainViewModel(navigation)
                AddViewModel::class.java -> AddViewModel(repository, listLiveDataWrapper, clearViewModel, navigation)
                ListViewModel::class.java -> ListViewModel(repository, listLiveDataWrapper, navigation)

                else -> throw  IllegalStateException("unknown viewModelClass $viewModelClass")
            } as T
        }

    }

}