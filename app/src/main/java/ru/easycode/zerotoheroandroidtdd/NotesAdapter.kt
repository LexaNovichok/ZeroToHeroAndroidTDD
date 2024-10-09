package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
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
        val diffUtil = DiffUtilCallback(notesList, newList)
        val diff = DiffUtil.calculateDiff(diffUtil)
        notesList.clear()
        notesList.addAll(newList)
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("LALALA", "onCreateViewHolder")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("LALALA", "onBindViewHolder")
        holder.bind(notesList[position])
    }
}

private class DiffUtilCallback(
    private val old : List<NoteModel>,
    private val new : List<NoteModel>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

}
