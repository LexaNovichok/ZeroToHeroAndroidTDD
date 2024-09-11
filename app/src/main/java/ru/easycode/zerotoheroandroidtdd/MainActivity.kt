package ru.easycode.zerotoheroandroidtdd

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar : ProgressBar
    private lateinit var textView: TextView
    private lateinit var actionButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.titleTextView)
        actionButton = findViewById(R.id.actionButton)


        actionButton.setOnClickListener {
            lifecycleScope.launch {
                load(progressBar, textView, actionButton);
            }

        }
    }

    private suspend fun load(progressBar: ProgressBar, textView: TextView, button : Button) {
        progressBar.visibility = View.VISIBLE
        button.isEnabled = false
        delay(3000)
        textView.visibility = View.VISIBLE
        progressBar.visibility = View.INVISIBLE
        button.isEnabled = true
    }
}