package com.sanikchar.vitattendancetracker.ui.home.tab2.students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sanikchar.vitattendancetracker.databinding.FragmentStudentBinding
import com.sanikchar.vitattendancetracker.model.StudentInfo

class StudentFragment : Fragment() {
    private lateinit var binding: FragmentStudentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStudentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val studentAdapter = StudentAdapter()

        binding.recyclerView.adapter = studentAdapter

        return Toast.makeText(requireContext(), "student list fragment", Toast.LENGTH_SHORT).show()
    }
}