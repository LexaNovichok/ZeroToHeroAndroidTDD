package ru.easycode.zerotoheroandroidtdd

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var text : TextView
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.titleTextView)
        button = findViewById(R.id.hideButton)

        button.setOnClickListener {
            text.visibility = View.INVISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_VISIBILITY, text.visibility)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        text.visibility = savedInstanceState.getInt(KEY_VISIBILITY)
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        private const val KEY_VISIBILITY = "visibility"
    }
}

