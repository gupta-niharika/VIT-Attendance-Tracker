package com.sanikchar.vitattendancetracker.ui.home.faq

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sanikchar.vitattendancetracker.model.FAQInfo

class FAQAdapter:ListAdapter<FAQInfo, FAQViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQViewHolder {
        return FAQViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: FAQViewHolder, position: Int) {
        return holder.bind(faqInfo = getItem(position))
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FAQInfo>(){
        override fun areItemsTheSame(oldItem: FAQInfo, newItem: FAQInfo): Boolean =
            oldItem.id == newItem.id && oldItem.answer == newItem.answer

        override fun areContentsTheSame(oldItem: FAQInfo, newItem: FAQInfo): Boolean = false
    }
}