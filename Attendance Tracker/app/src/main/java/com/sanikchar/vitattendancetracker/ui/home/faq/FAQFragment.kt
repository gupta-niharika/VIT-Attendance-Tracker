package com.sanikchar.vitattendancetracker.ui.home.faq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sanikchar.vitattendancetracker.databinding.FragmentFaqBinding

class FAQFragment : Fragment() {
    private lateinit var binding: FragmentFaqBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFaqBinding.inflate(inflater, container, false)
        return binding.root
    }
}