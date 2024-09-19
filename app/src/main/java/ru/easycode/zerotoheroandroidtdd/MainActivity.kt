package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, MainViewModelFactory(LiveDataWrapper.Base(), Repository.Base()))[MainViewModel::class.java]
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.setCurrentState()

        binding.actionButton.setOnClickListener {
            viewModel.load()
        }
    }
}