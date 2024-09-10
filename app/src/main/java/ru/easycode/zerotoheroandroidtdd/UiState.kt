package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(textView : TextView, buttonInc : Button, buttonDec : Button)

    abstract class UiAbstractState(private val text : String) : UiState {
        override fun apply(textView: TextView, buttonInc: Button, buttonDec: Button) {
            textView.text = text
        }
    }
    data class Base(private val text : String) : UiAbstractState(text) {
        override fun apply(textView: TextView, buttonInc: Button, buttonDec: Button) {
            super.apply(textView, buttonInc, buttonDec)
            buttonDec.isEnabled = true
            buttonInc.isEnabled = true
        }
    }

    data class Max(private val text : String) : UiAbstractState(text) {
        override fun apply(textView: TextView, buttonInc: Button, buttonDec: Button) {
            super.apply(textView, buttonInc, buttonDec)
            buttonInc.isEnabled = false
            Log.d("TEST", "buttonDec: ${buttonDec.isEnabled}" +
                    "\nbuttonInc: ${buttonInc.isEnabled}")
            buttonDec.isEnabled = true
        }
    }

    data class Min(private val text : String) : UiAbstractState(text) {
        override fun apply(textView: TextView, buttonInc: Button, buttonDec: Button) {
            super.apply(textView, buttonInc, buttonDec)
            buttonDec.isEnabled = false
        }
    }
}