package com.sanikchar.vitattendancetracker.ui.home.tab1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
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

        val classlist = listOf(
            ClassInfo(
                subName = "DSA",
                code = "SWE1002",
                stuCount = 43,
                startTime = Time(System.currentTimeMillis()),
            ),
            ClassInfo(
                subName = "Networks",
                code = "SWE1002",
                stuCount = 43,
                startTime = Time(System.currentTimeMillis()),
            ),
            ClassInfo(
                subName = "DBMS",
                code = "SWE1002",
                stuCount = 43,
                startTime = Time(System.currentTimeMillis()),
            ),
            ClassInfo(
                subName = "OS",
                code = "SWE1002",
                stuCount = 43,
                startTime = Time(System.currentTimeMillis()),
            ),ClassInfo(
                subName = "DSA",
                code = "SWE1002",
                stuCount = 43,
                startTime = Time(System.currentTimeMillis()),
            ),
            ClassInfo(
                subName = "Networks",
                code = "SWE1002",
                stuCount = 43,
                startTime = Time(System.currentTimeMillis()),
            ),
            ClassInfo(
                subName = "DBMS",
                code = "SWE1002",
                stuCount = 43,
                startTime = Time(System.currentTimeMillis()),
            ),
            ClassInfo(
                subName = "OS",
                code = "SWE1002",
                stuCount = 43,
                startTime = Time(System.currentTimeMillis()),
            ),

            )


        val recyclerAdapter = RecyclerAdapter()
        recyclerAdapter.classlist = classlist
        binding.root.adapter = recyclerAdapter
    }
}