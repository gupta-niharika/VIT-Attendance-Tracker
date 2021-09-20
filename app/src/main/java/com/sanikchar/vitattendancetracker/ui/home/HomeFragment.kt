package com.sanikchar.vitattendancetracker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.sanikchar.vitattendancetracker.R
import com.sanikchar.vitattendancetracker.databinding.FragmentHomeBinding
import com.sanikchar.vitattendancetracker.ui.home.tab1.Tab1Fragment
import com.sanikchar.vitattendancetracker.ui.home.tab2.Tab2Fragment

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
            val viewPagerAdapter = ViewPagerAdapter(this@HomeFragment)
            viewPager2.adapter = viewPagerAdapter
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.text = when (position) {
                    0 -> "Today's Classes"
                    else -> "All Classes"
                }
            }.attach()

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

    class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> Tab1Fragment()
            else -> Tab2Fragment()
        }

    }
}