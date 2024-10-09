package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val list = mutableListOf<NoteModel>()
    private val notesLiveData : MutableLiveData<List<NoteModel>> = MutableLiveData(list)

    fun addNote(note : NoteModel) {
        list.add(note)
        notesLiveData.value = list
    }

    fun removeNote(position : Int) {
        list.removeAt(position)
        notesLiveData.value = list
    }

    fun getNoteList() : List<NoteModel> = list

    fun notesLiveData() : LiveData<List<NoteModel>> = notesLiveData
}