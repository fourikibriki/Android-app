package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: Adapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val tabNames: Array<String> = arrayOf (
    "Камеры",
    "Двери"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = Adapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter


        tabLayout = findViewById(R.id.tab_layout)

        TabLayoutMediator(tabLayout,viewPager){tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }




}