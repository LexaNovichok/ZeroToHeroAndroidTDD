package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {

    interface Save {
        fun save(list : ArrayList<NoteModel>)

    }

    interface Restore {
        fun restore() : List<NoteModel>
    }

    interface Mutable : Save, Restore

    class Base(
        private val bundle: Bundle
    ) : Mutable {
        override fun save(list: ArrayList<NoteModel>) {
            bundle.putSerializable(KEY, list)
        }

        override fun restore(): List<NoteModel> = bundle.getSerializable(KEY) as List<NoteModel>


        companion object {
            private const val KEY = "KEY"
        }
    }
}