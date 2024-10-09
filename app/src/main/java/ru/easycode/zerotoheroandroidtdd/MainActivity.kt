package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter : NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = MainViewModel(ListLiveDataWrapper.Base())

        initRcView()

        binding.actionButton.setOnClickListener {
            binding.inputEditText.text?.let {
                mainViewModel.add(it.toString())
            }
            binding.inputEditText.setText("")
        }

        mainViewModel.liveData().observe(this) { list ->
            adapter.update(list)
        }
    }

    private fun initRcView() = with(binding) {
        adapter = NotesAdapter()
        recyclerView.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mainViewModel.save(BundleWrapper.Base(outState))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mainViewModel.restore(BundleWrapper.Base(savedInstanceState))
    }

}