package com.sanikchar.vitattendancetracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sanikchar.vitattendancetracker.practisercv.UserAdapter
import com.sanikchar.vitattendancetracker.practisercv.UserModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songlist = UserModel.songlist

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val userAdapter = UserAdapter()
        userAdapter.userList = songlist
        recyclerView.adapter = userAdapter
    }
}