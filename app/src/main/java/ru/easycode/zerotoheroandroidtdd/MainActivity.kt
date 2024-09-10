package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var counterTextView : TextView
    private lateinit var incButton : Button
    private var count = Count.Base(2,4)
    private var uiState : UiState = UiState.Base("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterTextView = findViewById(R.id.countTextView)
        incButton = findViewById(R.id.incrementButton)

        incButton.setOnClickListener {
            uiState = count.increment(counterTextView.text.toString())
            uiState.apply(counterTextView, incButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putSerializable(UI_KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(UI_KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(UI_KEY) as UiState
        }
        uiState.apply(counterTextView, incButton)
        
    }
    companion object {
        private const val UI_KEY = "UI_KEY"
    }
}