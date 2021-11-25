package main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.androidapp.CamerasFragment
import com.example.androidapp.DoorsFragment

class MyPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                CamerasFragment()
            }
            else-> { DoorsFragment()
            }


        }
    }

    override fun getCount(): Int {
        return 2
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Cameras Tab"
            else -> {"Doors Tab"
            }


        }
    }
}