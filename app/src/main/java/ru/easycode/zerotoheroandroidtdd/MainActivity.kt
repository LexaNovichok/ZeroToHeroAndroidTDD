package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonInc : Button
    private lateinit var countTextView: TextView
    private val count  = Count.Base(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonInc = findViewById(R.id.incrementButton)
        countTextView = findViewById(R.id.countTextView)

        buttonInc.setOnClickListener {
            var number = countTextView.text.toString()
            countTextView.setText(count.increment(number))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putCharSequence(KEY, countTextView.text)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        countTextView.setText(savedInstanceState.getString(KEY))
    }

    companion object {
        private const val KEY = "KEY"
    }
}
