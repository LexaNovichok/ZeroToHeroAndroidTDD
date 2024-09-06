package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var buttonChange : Button
    private lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text =  findViewById(R.id.titleTextView)
        buttonChange = findViewById(R.id.changeButton)

        buttonChange.setOnClickListener {
            text.text = "I am an Android Developer!"
        }
    }


}