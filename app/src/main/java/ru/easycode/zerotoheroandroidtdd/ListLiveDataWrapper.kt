package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map

interface ListLiveDataWrapper {

    fun liveData() : LiveData<List<NoteModel>>

    fun add(note : NoteModel)

    fun save(bundle : BundleWrapper.Save)

    fun update(list : List<NoteModel>)

    class Base(
        private val notesLiveData: MutableLiveData<ArrayList<NoteModel>> = SingleLiveEvent<ArrayList<NoteModel>>()
    ) : ListLiveDataWrapper {

        override fun liveData(): LiveData<List<NoteModel>> = notesLiveData.map { it.toList() }

        override fun add(note: NoteModel) {
            val currentList = notesLiveData.value ?: ArrayList()
            currentList.add(note)
            update(currentList)
        }

        override fun save(bundle: BundleWrapper.Save) {
//            notesLiveData.value?.let {
//                bundle.save(ArrayList(it))
//            }
            bundle.save(notesLiveData.value ?: ArrayList())
        }

        override fun update(list: List<NoteModel>) {
            notesLiveData.value = ArrayList(list)
        }
    }
}