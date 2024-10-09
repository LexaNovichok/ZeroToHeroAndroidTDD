package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val listLiveDataWrapper: ListLiveDataWrapper
) : ViewModel() {

    fun add(text : String) {
        val note = NoteModel(text)
        listLiveDataWrapper.add(note)
    }

    fun save(bundle : BundleWrapper.Save) {
        listLiveDataWrapper.save(bundle)
    }

    fun restore(bundle : BundleWrapper.Restore) {
        val list = bundle.restore()
        listLiveDataWrapper.update(list)
    }

    fun liveData() : LiveData<List<NoteModel>> = listLiveDataWrapper.liveData()

}