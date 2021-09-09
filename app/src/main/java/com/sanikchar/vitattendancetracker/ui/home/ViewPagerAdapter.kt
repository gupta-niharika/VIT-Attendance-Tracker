package com.sanikchar.vitattendancetracker.ui.home

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sanikchar.vitattendancetracker.ui.home.tab1.Tab1Fragment
import com.sanikchar.vitattendancetracker.ui.home.tab2.Tab2Fragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = 2

    override fun getItem(position: Int) = when (position) {
        0 -> Tab1Fragment()
        else -> Tab2Fragment()
    }

    override fun getPageTitle(position: Int) = when (position) {
        0 -> "Today's classes"
        else -> "All classes"
    }
}