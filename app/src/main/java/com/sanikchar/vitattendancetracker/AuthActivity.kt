package com.sanikchar.vitattendancetracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sanikchar.vitattendancetracker.databinding.ActivityLoginBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
    }

}