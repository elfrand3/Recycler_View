package com.example.viewpages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AdapterView(first: FragmentManager): FragmentPagerAdapter(first){

    private val viewpager = listOf(
        FirstFragment(),
        SecondFragment(),
        ThirdFragment()
    )

    override fun getCount(): Int {
        return viewpager.size
    }

    override fun getItem(position: Int): Fragment {
        return viewpager[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "First"
            1 -> "Second"
            else -> "Third"
        }
    }
}