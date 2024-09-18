package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun apply(actionButton : Button, progressBar: ProgressBar, titleTextView : TextView)

    object Initial : UiState {
        override fun apply(
            actionButton: Button,
            progressBar: ProgressBar,
            titleTextView: TextView
        ) {
            titleTextView.visibility = View.INVISIBLE
            progressBar.visibility = View.INVISIBLE
            actionButton.isEnabled = true
        }

    }

    object ShowProgress : UiState {
        override fun apply(
            actionButton: Button,
            progressBar: ProgressBar,
            titleTextView: TextView
        ) {
            progressBar.visibility = View.VISIBLE
            actionButton.isEnabled = false
            titleTextView.visibility = View.INVISIBLE
        }

    }

    object ShowData : UiState {
        override fun apply(
            actionButton: Button,
            progressBar: ProgressBar,
            titleTextView: TextView
        ) {
            titleTextView.visibility = View.VISIBLE
            progressBar.visibility = View.INVISIBLE
            actionButton.isEnabled = true
        }
    }
}
