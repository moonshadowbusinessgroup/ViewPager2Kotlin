package com.hadimusthafa.viewpager2kotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity?, var mNumOfTabs: Int) :
    FragmentStateAdapter(
        fragmentActivity!!
    ) {

    override fun getItemCount(): Int {
        return mNumOfTabs
    }

    override fun createFragment(position: Int): Fragment {
       return when (position){
            0 -> FragmentOne()
            1 -> FragmentTwo()
           else -> null!!
       }
    }
}