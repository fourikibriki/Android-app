package com.example.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import info.fandroid.myapplication18.ARG_OBJECT
import info.fandroid.myapplication18.NumberFragment

class Adapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int=2
    override fun createFragment(position: Int): Fragment {
        val fragment=NumberFragment()
        fragment.arguments=Bundle().apply {
            putInt(ARG_OBJECT, position+1)
        }


       return fragment
    }
}