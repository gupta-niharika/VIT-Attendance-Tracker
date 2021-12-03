package com.sanikchar.vitattendancetracker.ui.home.tab2

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sanikchar.vitattendancetracker.model.ClassInfo

class ClassAdapter : ListAdapter<ClassInfo, ClassViewHolder>(DiffCallback) {

//    var classlist = listOf<ClassInfo>()
//        set(value) {    //setter
//            field = value
//            notifyDataSetChanged()
//        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder =
        ClassViewHolder.create(parent)

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) =
        holder.bind(classInfo = getItem(position))

    companion object DiffCallback : DiffUtil.ItemCallback<ClassInfo>() {
        override fun areItemsTheSame(oldItem: ClassInfo, newItem: ClassInfo): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ClassInfo, newItem: ClassInfo): Boolean = false
    }
}
