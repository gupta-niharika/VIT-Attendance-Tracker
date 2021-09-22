package com.sanikchar.vitattendancetracker.ui.home.tab1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sanikchar.vitattendancetracker.databinding.FragmentTab1Binding
import com.sanikchar.vitattendancetracker.model.ClassInfo
import java.sql.Time

private const val TAG = "Tab1Fragment"

class Tab1Fragment : Fragment() {

    private lateinit var binding: FragmentTab1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTab1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated: ")

        val recyclerAdapter = TClassAdapter()

        binding.root.adapter = recyclerAdapter
    }
}