package ru.easycode.zerotoheroandroidtdd.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.R
import ru.easycode.zerotoheroandroidtdd.databinding.ItemBinding
import ru.easycode.zerotoheroandroidtdd.db.Item

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val list : ArrayList<Item> = arrayListOf()
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val binding = ItemBinding.bind(view)

        fun bind(item : Item) = with(binding) {
            elementTextView.text = item.text
        }
    }

    fun update(newList : MutableList<Item>) {
        val diffUtil = DiffUtilCallBack(list, newList)
        val diff = DiffUtil.calculateDiff(diffUtil)

        list.clear()
        list.addAll(newList)
        diff.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


    class DiffUtilCallBack(
        private val old : List<Item>,
        private val new : List<Item>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = old.size

        override fun getNewListSize(): Int = new.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            old[oldItemPosition].id == new[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            old[oldItemPosition].text == new[newItemPosition].text
    }

}