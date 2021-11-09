package com.vaishnav.pratilipiproject.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vaishnav.pratilipiproject.data.model.Content
import com.vaishnav.pratilipiproject.databinding.RvItemBinding

class MainAdapter : ListAdapter<Content, MainAdapter.AViewHolder>(DataComparator()) {
    inner class AViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class DataComparator : DiffUtil.ItemCallback<Content>() {
        override fun areContentsTheSame(oldItem: Content, newItem: Content) =
            oldItem.id == newItem.id

        override fun areItemsTheSame(oldItem: Content, newItem: Content) =
            oldItem === newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AViewHolder {
        val binding =
            RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: AViewHolder, position: Int) {
        RvItemBinding.bind(holder.itemView).apply {
            val currentData = getItem(position)

            tvTitle.text = currentData.title
            tvText.text = currentData.text
        }
    }
}