package ru.easycode.zerotoheroandroidtdd

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import ru.easycode.zerotoheroandroidtdd.databinding.ListItemBinding
import java.io.Serializable

interface ListItem : Serializable {

    fun create() : View

    data class ItemOne(
        private val inflater: LayoutInflater,
        val text: String,
        val image : Uri?
    ) : ListItem {
        override fun create() : View {
            val binding = ListItemBinding.inflate(inflater)

            binding.titleTextView.text = text
            image?.let {
                binding.image.setImageURI(it)
            } ?: run {
                binding.image.setImageResource(R.drawable.ic_launcher_background)
            }

            return binding.root
        }
    }
}

