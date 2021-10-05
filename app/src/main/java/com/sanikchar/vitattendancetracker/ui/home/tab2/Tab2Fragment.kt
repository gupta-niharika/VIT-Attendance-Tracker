package com.sanikchar.vitattendancetracker.ui.home.tab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.sanikchar.vitattendancetracker.databinding.FragmentTab2Binding
import com.sanikchar.vitattendancetracker.ui.home.HomeFragmentDirections

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

        val classAdapter = ClassAdapter()

        binding.recyclerView.adapter = classAdapter

        binding.fab.setOnClickListener {
            findNavController(this)
                .navigate(HomeFragmentDirections.actionHomeFragmentToAddClassFragment())
        }

//        binding.fab.setOnClickListener {
//            findNavController(this)
//                .navigate(Tab2FragmentDirections.actionTab2FragmentToAddClassFragment())
//        }
    }
}