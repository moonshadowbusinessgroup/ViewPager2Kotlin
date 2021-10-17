package com.hadimusthafa.viewpager2kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.widget.TextView
import com.hadimusthafa.viewpager2kotlin.R
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.hadimusthafa.viewpager2kotlin.ViewPagerAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hadimusthafa.viewpager2kotlin.FragmentOne
import com.hadimusthafa.viewpager2kotlin.FragmentTwo

class TabActivity : AppCompatActivity() {
    private var viewPager: ViewPager2? = null
    private var tabLayout: TabLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tab)
        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)
        tabLayout?.addTab(tabLayout?.newTab()!!.setText("New Order"))
        tabLayout?.addTab(tabLayout?.newTab()!!.setText("Completed Order"))
        val pagerAdapter = ViewPagerAdapter(this, 2)
        viewPager?.setAdapter(pagerAdapter)
        viewPager?.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout?.selectTab(tabLayout?.getTabAt(position))
            }
        })
        tabLayout?.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager?.setCurrentItem(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}