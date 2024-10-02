package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.inputEditText.addTextChangedListener {
            binding.actionButton.isEnabled = binding.inputEditText.text.toString().length >= 3
        }

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()

            binding.titleTextView.text = text
            binding.inputEditText.setText("")
        }
    }
}