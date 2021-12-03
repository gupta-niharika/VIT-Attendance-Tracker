package com.sanikchar.vitattendancetracker.ui.home.tab1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanikchar.vitattendancetracker.R
import com.sanikchar.vitattendancetracker.databinding.ItemClassInfoBinding
import com.sanikchar.vitattendancetracker.model.ClassInfo

class TClassViewHolder(private val binding: ItemClassInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val subName = binding.subName
    val classCode = binding.classCode
    val stuCount = binding.stuCount
    val classTime = binding.classTime

    fun bind(classInfo: ClassInfo) {
        subName.text = classInfo.subName
        classCode.text = classInfo.code
        stuCount.text = classInfo.stuCount.toString()
        classTime.text = classInfo.startTime.toString()
    }

    companion object {
        fun create(parent: ViewGroup): TClassViewHolder {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_class_info, parent, false)
            return TClassViewHolder(ItemClassInfoBinding.bind(view))
        }
    }
}