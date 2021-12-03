package com.sanikchar.vitattendancetracker.ui.home.tab1

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sanikchar.vitattendancetracker.model.ClassInfo

class TClassAdapter :
    ListAdapter<ClassInfo, TClassViewHolder>(DiffCallback) {

//    var classlist = listOf<ClassInfo>()
//        set(value) {    //setter
//            field = value
//            notifyDataSetChanged()
//        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TClassViewHolder =
        TClassViewHolder.create(parent)

    override fun onBindViewHolder(holder: TClassViewHolder, position: Int) =
        holder.bind(classInfo = getItem(position))

    companion object DiffCallback : DiffUtil.ItemCallback<ClassInfo>() {
        override fun areItemsTheSame(oldItem: ClassInfo, newItem: ClassInfo): Boolean =
            oldItem.code == newItem.code && oldItem.startTime == newItem.startTime

        override fun areContentsTheSame(oldItem: ClassInfo, newItem: ClassInfo): Boolean = false
    }
}
