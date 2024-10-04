package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val textList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            val currentText = binding.inputEditText.text.toString()

            textList.add(currentText)
            addItem(currentText)
            binding.inputEditText.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList(KEY, textList)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val list = savedInstanceState.getStringArrayList(KEY)?: ArrayList()
        textList.addAll(list)

        list.forEach { item ->
            addItem(item)
        }
    }

    private fun addItem(text : String) {
        val textView = TextView(this)
        textView.text = text
        textView.textSize = 22f

        binding.contentLayout.addView(textView)
    }

    companion object {
        private const val KEY = "KEY"
    }
}