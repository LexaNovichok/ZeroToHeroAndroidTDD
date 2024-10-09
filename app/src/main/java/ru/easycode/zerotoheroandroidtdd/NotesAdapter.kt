package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemBinding

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    private var notesList : ArrayList<NoteModel> = arrayListOf()
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemBinding.bind(view)

        fun bind(item : NoteModel) = with(binding) {
            elementTextView.text = item.text
        }
    }

    fun update(newList : List<NoteModel>) {
        notesList.clear()
        notesList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(notesList[position])
    }
}