package com.sanikchar.vitattendancetracker.practisercv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sanikchar.vitattendancetracker.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val singer = itemView.findViewById<TextView>(R.id.tvSinger)
    val song = itemView.findViewById<TextView>(R.id.tvSong)

    fun bind(userModel: UserModel) {
        singer.text = userModel.singer
        song.text = userModel.song
    }

    companion object {
        fun create(parent: ViewGroup) : UserViewHolder{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
            return UserViewHolder(view)
        }
    }
}