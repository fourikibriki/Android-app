package com.example.app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

abstract class MyViewPagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {

    fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                BlankFragment1()
            }
            1 -> BlankFragment2()
            else -> {
                return BlankFragment1()
            }
        }
    }

    fun getCount(): Int {
        return 2
    }

    fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Камеры"
            1 -> "Двери"
            else -> {
                return "Third Tab"
            }
        }
    }

}