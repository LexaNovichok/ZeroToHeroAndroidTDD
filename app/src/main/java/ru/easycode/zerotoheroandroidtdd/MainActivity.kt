package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val context = this
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel : MainViewModel
    private lateinit var adapter : NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = MainViewModel()
        initRcView()

        binding.actionButton.setOnClickListener {
            binding.inputEditText.text?.let {
                val note = NoteModel(it.toString())
                mainViewModel.addNote(note)
            }
            binding.inputEditText.setText("")
        }

        mainViewModel.notesLiveData().observe(this) { list->
            Log.d("LALALA", "List has been changed")
            adapter.setNotes(list)
        }
    }


    private fun initRcView() = with(binding) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = NotesAdapter(mainViewModel.getNoteList())
        recyclerView.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, ArrayList(mainViewModel.getNoteList()))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val listRestored = savedInstanceState.getSerializable(KEY) as List<NoteModel>
        listRestored.forEach {
            mainViewModel.addNote(it)
        }
    }

    companion object {
        private const val KEY = "KEY"
    }
}