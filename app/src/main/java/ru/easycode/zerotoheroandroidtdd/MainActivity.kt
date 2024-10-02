package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                binding.actionButton.isEnabled = binding.inputEditText.text.toString().length >= 3
            }

        }

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            binding.titleTextView.text = text
            binding.inputEditText.removeTextChangedListener(textWatcher)
            binding.inputEditText.setText("")
            binding.actionButton.isEnabled = false
            binding.inputEditText.addTextChangedListener(textWatcher)
        }

        binding.inputEditText.addTextChangedListener(textWatcher)
    }
}