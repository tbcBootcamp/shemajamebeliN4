package com.example.shemajamebeli4.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli4.data.ItemModel
import com.example.shemajamebeli4.databinding.RecyclerItemBinding

class ItemModelAdapter : ListAdapter<ItemModel, ItemModelAdapter.ItemModelViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemModelViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemModelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemModelViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemModelViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel) {
            // Bind data to views using the generated binding class
            binding.textViewName.text = item.owner
            binding.textViewLastMessage.text = item.lastMessage
            binding.textViewLastActive.text = item.lastActive
            // ... Bind other data as needed
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<ItemModel>() {
        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            // You might need a more specific check based on your data
            return oldItem == newItem
        }
    }
}