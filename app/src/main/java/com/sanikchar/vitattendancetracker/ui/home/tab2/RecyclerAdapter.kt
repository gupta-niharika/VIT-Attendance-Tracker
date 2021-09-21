package com.sanikchar.vitattendancetracker.ui.home.tab2

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sanikchar.vitattendancetracker.model.ClassInfo

class RecyclerAdapter : ListAdapter<ClassInfo, RecyclerViewHolder>(DiffCallback) {

//    var classlist = listOf<ClassInfo>()
//        set(value) {    //setter
//            field = value
//            notifyDataSetChanged()
//        }

    companion object DiffCallback : DiffUtil.ItemCallback<ClassInfo>() {
        override fun areItemsTheSame(oldItem: ClassInfo, newItem: ClassInfo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ClassInfo, newItem: ClassInfo): Boolean {
            return false
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder =
        RecyclerViewHolder.create(parent)

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) =
        holder.bind(classInfo = getItem(position))
}