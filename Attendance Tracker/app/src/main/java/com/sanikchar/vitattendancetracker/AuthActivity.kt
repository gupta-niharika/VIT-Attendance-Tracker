package com.sanikchar.vitattendancetracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sanikchar.vitattendancetracker.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
    }

}