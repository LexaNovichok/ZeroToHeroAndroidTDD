package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val itemList: MutableList<ListItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            val currentText = binding.inputEditText.text.toString()
            val currentItem = ListItem.ItemOne(layoutInflater, currentText, null)

            itemList.add(currentItem)

            binding.contentLayout.addView(currentItem.create())

            binding.inputEditText.setText("")
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val arrayList = ArrayList(itemList)
        outState.putSerializable(KEY_ITEM_LIST, arrayList)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val list = savedInstanceState.getSerializable(KEY_ITEM_LIST) as ArrayList<ListItem>
        itemList.addAll(list)

        Log.d("LALALA", itemList.toString())
        itemList.forEach {listItem ->
            if (listItem is ListItem.ItemOne) {
                val newItemView = ListItem.ItemOne(layoutInflater, listItem.text, listItem.image).create()
                binding.contentLayout.addView(newItemView)
            }
        }
    }

    companion object {
        private const val KEY_ITEM_LIST = "KEY_ITEM_LIST"
    }
}