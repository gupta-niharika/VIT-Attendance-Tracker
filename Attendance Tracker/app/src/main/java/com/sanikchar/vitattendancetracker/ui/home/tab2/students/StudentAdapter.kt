package com.sanikchar.vitattendancetracker.ui.home.tab2.students

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sanikchar.vitattendancetracker.model.StudentInfo

class StudentAdapter : ListAdapter<StudentInfo, StudentViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder =
        StudentViewHolder.create(parent)

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) =
        holder.bind(stuInfo = getItem(position))

    companion object DiffCallback : DiffUtil.ItemCallback<StudentInfo>() {
        override fun areItemsTheSame(oldItem: StudentInfo, newItem: StudentInfo): Boolean =
            oldItem.regNo == newItem.regNo

        override fun areContentsTheSame(oldItem: StudentInfo, newItem: StudentInfo): Boolean = false
    }
}