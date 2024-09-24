package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(textView: TextView, actionButton: Button, progressBar: ProgressBar)

    object ShowProgress : UiState {
        override fun apply(textView: TextView, actionButton: Button, progressBar: ProgressBar) {
            textView.visibility = View.INVISIBLE
            actionButton.isEnabled = false
            progressBar.visibility = View.VISIBLE
        }
    }

    object ShowData : UiState {
        override fun apply(textView: TextView, actionButton: Button, progressBar: ProgressBar) {
            textView.visibility = View.VISIBLE
            actionButton.isEnabled = true
            progressBar.visibility = View.INVISIBLE
        }

    }
}