package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {

    interface Save {
        fun save(list : ArrayList<String>)
    }

    interface Restore {
        fun restore() : ArrayList<String>
    }

    class Base(private val bundle: Bundle) : Save, Restore {
        override fun save(list: ArrayList<String>) {
            bundle.putStringArrayList(KEY, list)
        }

        override fun restore(): ArrayList<String> {
            return bundle.getStringArrayList(KEY) as ArrayList<String>
        }
    }

    companion object {
        private const val KEY = "KEY"
    }
}
