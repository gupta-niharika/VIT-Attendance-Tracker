package com.sanikchar.vitattendancetracker.ui.home.tab1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanikchar.vitattendancetracker.R
import com.sanikchar.vitattendancetracker.databinding.ItemClassInfoBinding
import com.sanikchar.vitattendancetracker.model.ClassInfo

class RecyclerViewHolder(private val binding: ItemClassInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(classInfo: ClassInfo) {


    }

    companion object {
        fun create(parent: ViewGroup): RecyclerViewHolder {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_class_info, parent, false)
            return RecyclerViewHolder(ItemClassInfoBinding.bind(view))
        }
    }
}