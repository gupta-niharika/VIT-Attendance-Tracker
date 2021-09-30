package com.sanikchar.vitattendancetracker.ui.home.faq

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanikchar.vitattendancetracker.databinding.ItemFaqBinding
import com.sanikchar.vitattendancetracker.model.FAQInfo

class FAQViewHolder(private val binding: ItemFaqBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(faqInfo: FAQInfo) {
        binding.apply {
            question.text = faqInfo.question
            answer.text = faqInfo.answer
        }
    }

    companion object {
        fun create(view: ViewGroup): FAQViewHolder {
            val binding = ItemFaqBinding.inflate(LayoutInflater.from(view.context), view, false)
            return FAQViewHolder(binding)
        }
    }
}