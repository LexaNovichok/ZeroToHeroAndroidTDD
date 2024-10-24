package ru.easycode.zerotoheroandroidtdd.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProvideViewModel {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = viewModel(MainViewModel::class.java)

        viewModel.init()

        viewModel.liveData().observe(this) { screen->
            screen.show(supportFragmentManager, binding.container.id)
        }
    }

    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T =
        (application as ProvideViewModel).viewModel(viewModelClass)


}