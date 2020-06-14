package com.example.fitinus


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_c.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentC(var c : Context) : Fragment() {

    lateinit var adapter : music_Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //data load
        var music_data : ArrayList<music> = ArrayList<music>()
        music_data.add(music("나얼","같은 시간 속의 너"))
        music_data.add(music("넬","기억을 걷는 시간"))
        //adapter
        adapter = music_Adapter(c,music_data)
        var layoutManager = LinearLayoutManager(c, RecyclerView.VERTICAL, false)
        music_list.layoutManager = layoutManager
        music_list.adapter = adapter
    }


}
