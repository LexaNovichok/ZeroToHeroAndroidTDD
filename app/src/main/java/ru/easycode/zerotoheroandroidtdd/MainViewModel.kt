package ru.easycode.zerotoheroandroidtdd

import android.content.Context
import android.widget.TextView
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Base
) : ViewModel() {

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val list = bundleWrapper.restore()
        liveDataWrapper.update(list)
    }

    fun liveData() = liveDataWrapper.liveData()

    fun createTextView(context : Context, text : String) : TextView {
        val textView = TextView(context)
        textView.text = text
        textView.paddingTop.plus(8)

        return textView
    }

}