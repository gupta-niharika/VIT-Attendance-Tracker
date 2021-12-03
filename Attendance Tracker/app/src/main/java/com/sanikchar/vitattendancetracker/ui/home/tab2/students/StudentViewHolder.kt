package com.sanikchar.vitattendancetracker.ui.home.tab2.students

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanikchar.vitattendancetracker.databinding.ItemStudentListBinding
import com.sanikchar.vitattendancetracker.model.StudentInfo

class StudentViewHolder(private val binding: ItemStudentListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(stuInfo: StudentInfo) {
        binding.apply {
            stuName.text = stuInfo.stuName
            regNo.text = stuInfo.regNo
            presence.text = stuInfo.presence.toString()
        }
    }

    companion object {
        fun create(parent: ViewGroup): StudentViewHolder {
            val binding = ItemStudentListBinding.inflate( LayoutInflater.from(parent.context), parent, false )
            return StudentViewHolder(ItemStudentListBinding.bind(binding.root))
        }
    }
}