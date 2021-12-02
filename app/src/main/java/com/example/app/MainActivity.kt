package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator




class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MyViewPagerAdapter

    private lateinit var viewPager: ViewPager2

    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewPager.adapter = adapter


       tabLayout = findViewById(R.id.tabMode)
    }

}



