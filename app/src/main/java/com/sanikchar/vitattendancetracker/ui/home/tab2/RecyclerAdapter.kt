package com.sanikchar.vitattendancetracker.ui.home.tab2

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanikchar.vitattendancetracker.model.ClassInfo

class RecyclerAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {

    var classlist = listOf<ClassInfo>()
        set(value) {    //setter
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder =
        RecyclerViewHolder.create(parent)

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) =
        holder.bind(classInfo = classlist[position])

    override fun getItemCount(): Int = classlist.size

}