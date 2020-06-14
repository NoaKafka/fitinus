package com.example.fitinus


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_c.*
import kotlinx.android.synthetic.main.fragment_d.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentD(var c : Context) : Fragment() {

    lateinit var adapter : friend_adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_d, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //data load
        var friend_data : ArrayList<friend> = ArrayList<friend>()
        friend_data.add(friend("hi","홍길동", "best"))
        friend_data.add(friend("hu","김길동", "bad"))
        friend_data.add(friend("me","박길동", "good"))
        //adapter
        adapter = friend_adapter(c,friend_data)
        var layoutManager = LinearLayoutManager(c, RecyclerView.VERTICAL, false)
        friend_list.layoutManager = layoutManager
        friend_list.adapter = adapter
    }
}
