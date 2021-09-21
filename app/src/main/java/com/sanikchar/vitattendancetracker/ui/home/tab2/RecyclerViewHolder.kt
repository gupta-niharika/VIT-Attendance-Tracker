package com.sanikchar.vitattendancetracker.ui.home.tab2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanikchar.vitattendancetracker.databinding.ItemClassCardBinding
import com.sanikchar.vitattendancetracker.model.ClassInfo

class RecyclerViewHolder(private val binding: ItemClassCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

//    val classTime = binding.classTime

    fun bind(classInfo: ClassInfo) {    //binding to the model
        binding.apply{
            subName.text = classInfo.subName
            classCode.text = classInfo.code
            stuCount.text = classInfo.stuCount.toString()
        }
//        classTime.text = classInfo.startTime.toString()
    }

    companion object {
        fun create(parent: ViewGroup): RecyclerViewHolder {
            val binding = ItemClassCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return RecyclerViewHolder(ItemClassCardBinding.bind(binding.root))
        }
    }
}