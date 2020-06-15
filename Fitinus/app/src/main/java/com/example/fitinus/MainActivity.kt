package com.example.fitinus


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.mipmap.menu_icon)

        var main_adapter = Main_pager_Adapter(supportFragmentManager)


        friend_List_VP.adapter = main_adapter
        friend_List_VP.offscreenPageLimit = 3


        tabs_main.setupWithViewPager(friend_List_VP)
        tabs_main.getTabAt(0)?.setIcon(resources.getDrawable(R.mipmap.home))
        tabs_main.getTabAt(1)?.setIcon(resources.getDrawable(R.mipmap.chart))
        tabs_main.getTabAt(2)?.setIcon(resources.getDrawable(R.mipmap.music))
        tabs_main.getTabAt(3)?.setIcon(resources.getDrawable(R.mipmap.contact))

        tabs_main.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }
        })
    }

    inner class Main_pager_Adapter : FragmentPagerAdapter {

        var data1 : Fragment = FragmentA()
        var data2 : Fragment = FragmentB(applicationContext)
        var data3 : Fragment = FragmentC(applicationContext)
        var data4 : Fragment = FragmentD(applicationContext)


        var mData : ArrayList<Fragment> = arrayListOf(data1,data2,data3,data4)

        constructor(fm : FragmentManager) : super(fm){

        }

        override fun getItem(position: Int): Fragment {
            return mData.get(position)
        }

        override fun getCount(): Int {
            return mData.size
        }
    }
}
