package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var text : TextView

    private val KEY = "123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.changeButton)
        text = findViewById(R.id.titleTextView)

        savedInstanceState?.let {
            text.text = savedInstanceState.getString(KEY)
        }



        button.setOnClickListener {
            text.setText("I am an Android Developer!")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(KEY, text.text.toString())
        super.onSaveInstanceState(outState)
    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        var newText = savedInstanceState?.getString(KEY)
//        if (newText != null) {
//            text.setText(newText)
//        }
//    }


}