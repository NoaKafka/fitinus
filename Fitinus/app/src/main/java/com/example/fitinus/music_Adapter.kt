package com.example.fitinus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class music_Adapter (val context: Context,
                     var items:ArrayList<music>
):  RecyclerView.Adapter<music_Adapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context)
            .inflate(R.layout.item_music, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        holder.song_name.text = "  "+ data.song + " - "+ data.singer

        /*
        holder.kakao.setOnClickListener {
            //카카오톡 초대 메세지 보내기
            Toast.makeText(context, "kakaotalk", Toast.LENGTH_SHORT).show()
        }

        holder.switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(context, "On", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Off", Toast.LENGTH_SHORT).show()
            }
        }
        */
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mlist: ImageView

        var song_name: TextView


        var play_btn : ImageView
        var detail_btn : ImageView

        init {
            mlist = itemView.findViewById(R.id.mlist)
            song_name = itemView.findViewById(R.id.song)

            play_btn = itemView.findViewById(R.id.play)
            detail_btn = itemView.findViewById(R.id.detail)


            /*itemView.setOnClickListener {
                lastSelectedPosition = adapterPosition
                notifyDataSetChanged()
            }*/
        }
    }


}
