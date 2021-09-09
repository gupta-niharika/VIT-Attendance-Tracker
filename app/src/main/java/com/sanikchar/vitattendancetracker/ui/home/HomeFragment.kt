package com.sanikchar.vitattendancetracker.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.sanikchar.vitattendancetracker.AuthActivity
import com.sanikchar.vitattendancetracker.R
import com.sanikchar.vitattendancetracker.databinding.FragmentHomeBinding

private const val TAG = "HomeFragment"

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
            viewPager.adapter = viewPagerAdapter
            tabLayout.setupWithViewPager(viewPager)
            options.setOnClickListener { v ->
                val popupMenu = PopupMenu(requireContext(), v)
                val inflater = popupMenu.menuInflater
                inflater.inflate(R.menu.menu_options, popupMenu.menu)
                popupMenu.show()
                popupMenu.setOnMenuItemClickListener {
                    return@setOnMenuItemClickListener when (it.itemId) {
                        R.id.logout -> {
                            try {
                                FirebaseAuth.getInstance().signOut()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            true
                        }
                        else -> false
                    }
                }
            }
        }
    }
}