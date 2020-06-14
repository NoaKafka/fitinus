package com.example.fitinme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.content.SharedPreferences
import android.content.Context
import android.support.v4.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var main_adapter = Main_Pager_Adapter(supportFragmentManager)
        friend_List_VP.adapter = main_adapter
        friend_List_VP.offscreenPageLimit = 3

        tabs_main.setupWithViewPager(friend_List_VP)
        tabs_main.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }
        })

        //아이콘 설정
        /* tabs_main.getTabAt(0)?.setIcon(R.drawable.fragment_list)
         tabs_main.getTabAt(1)?.setIcon(R.drawable.chatting)
         tabs_main.getTabAt(2)?.setIcon(R.drawable.group)*/
    }
}
