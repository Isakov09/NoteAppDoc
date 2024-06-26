package com.example.noteappdoc.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.noteappdoc.databinding.ItemMassageBinding

class ChatAdapter :
    androidx.recyclerview.widget.ListAdapter<String, ChatAdapter.ViewHolder>(DiffCallback()) {
    class ViewHolder(private val binding: ItemMassageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: String?) {
            binding.itemMessage.text = message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMassageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}