package com.example.fitinme

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class Main_Pager_Adapter :  FragmentPagerAdapter{

    var data1 : Fragment = List()
    var data2 : Fragment = Chatting()
    var data3 : Fragment = Setting()

    var mData : ArrayList<Fragment> = arrayListOf(data1,data2,data3)

    constructor(fm : FragmentManager) : super(fm){

    }

    override fun getItem(position: Int): Fragment {
        return mData.get(position)
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "내 회원"
            1 -> "채팅"
            else -> {return "설정"}
        }
    }
}