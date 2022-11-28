package com.example.viewpages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.viewpages.fragment.FirstFragment
import com.example.viewpages.fragment.SecondFragment
import com.example.viewpages.fragment.ThirdFragment

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
            0 -> "Chat"
            1 -> "Status"
            else -> "Panggilan"
        }
    }
}