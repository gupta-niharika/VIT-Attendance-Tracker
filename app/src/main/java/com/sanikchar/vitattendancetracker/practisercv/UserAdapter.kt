package com.sanikchar.vitattendancetracker.practisercv

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {
    var userList = listOf<UserModel>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder.create(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(userModel = userList[position])

    override fun getItemCount(): Int = userList.size

}