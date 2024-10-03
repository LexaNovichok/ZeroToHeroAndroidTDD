package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val viewModel = (application as App).viewModel

        binding.actionButton.setOnClickListener {
            val addedText = binding.inputEditText.text.toString()

            viewModel.createTextView(this, addedText)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapper.Base(outState))

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.restore(BundleWrapper.Base(savedInstanceState))


        val list = viewModel.liveData().value

        if (list != null) {
            for (itemText in list) {
                binding.contentLayout.addView(viewModel.createTextView(this, itemText))
            }
        }
    }

}