package com.sanikchar.vitattendancetracker.ui.home.tab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.sanikchar.vitattendancetracker.R
import com.sanikchar.vitattendancetracker.databinding.FragmentTab2Binding
import com.sanikchar.vitattendancetracker.model.ClassInfo
import java.sql.Time

class Tab2Fragment : Fragment() {

    private lateinit var binding: FragmentTab2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTab2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "Tab2", Toast.LENGTH_LONG).show()


        val classAdapter = ClassAdapter()

        binding.recyclerView.adapter = classAdapter

        binding.fab.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_addClassFragment)
        }
    }
}