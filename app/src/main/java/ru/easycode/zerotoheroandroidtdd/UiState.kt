package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {
    fun apply(actionButton : Button, progressBar : ProgressBar, textView : TextView )

    object Initial : UiState {
        override fun apply(actionButton: Button, progressBar: ProgressBar, textView: TextView) {
            progressBar.visibility = View.INVISIBLE
            textView.visibility = View.INVISIBLE
            actionButton.isEnabled = true
        }
    }

    object ShowProgress : UiState {
        override fun apply(actionButton: Button, progressBar: ProgressBar, textView: TextView) {
            progressBar.visibility = View.VISIBLE
            textView.visibility = View.INVISIBLE
            actionButton.isEnabled = false
        }
    }

    object ShowData : UiState {
        override fun apply(actionButton: Button, progressBar: ProgressBar, textView: TextView) {
            progressBar.visibility = View.INVISIBLE
            textView.visibility = View.VISIBLE
            actionButton.isEnabled = true
        }
    }

}
