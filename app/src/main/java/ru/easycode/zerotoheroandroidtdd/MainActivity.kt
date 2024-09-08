package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonRemove : Button
    private lateinit var text : TextView
    private lateinit var linearLayout : LinearLayout
    private var isExist = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRemove = findViewById(R.id.removeButton)
        text = findViewById(R.id.titleTextView)
        linearLayout = findViewById(R.id.rootLayout)

        buttonRemove.setOnClickListener {
            linearLayout.removeView(text)
            isExist = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean("KEY", isExist)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (!savedInstanceState.getBoolean("KEY")) {
            linearLayout.removeView(text)

            //isExist = false
        }
    }
}