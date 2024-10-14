package ru.easycode.zerotoheroandroidtdd.list

import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.BundleWrapper
import ru.easycode.zerotoheroandroidtdd.create.CreateScreen
import ru.easycode.zerotoheroandroidtdd.main.Navigation


class ListViewModel(
    private val listLiveDataWrapper: ListLiveDataWrapper.Mutable,
    private val navigation : Navigation.Update
    ) : ViewModel(), ListLiveDataWrapper.Read {
    fun create() {
        navigation.update(CreateScreen)
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        listLiveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val list = bundleWrapper.restore()
        listLiveDataWrapper.update(list)
    }

    override fun liveData() = listLiveDataWrapper.liveData()
}