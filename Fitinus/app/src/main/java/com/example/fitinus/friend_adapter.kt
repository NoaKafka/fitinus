package com.example.fitinus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class friend_adapter(val context: Context,
                     var items:ArrayList<friend>
):  RecyclerView.Adapter<friend_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context)
            .inflate(R.layout.item_friend, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        //set friend's profile image
            //holder.f_image.setImageResource()
        holder.name.text = "  "+ data.name

        //friend's feeling
        if (data.feeling == "best"){
            holder.feel.setImageResource(R.mipmap.best)
        }
        else if(data.feeling == "good"){
            holder.feel.setImageResource(R.mipmap.good)
        }
        else if(data.feeling == "not_good"){
            holder.feel.setImageResource(R.mipmap.not_good)
        }
        else{
            holder.feel.setImageResource(R.mipmap.bad)
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var f_image: ImageView
        var name: TextView
        var feel : ImageView

        init {
            f_image = itemView.findViewById(R.id.f_image)
            name = itemView.findViewById(R.id.f_name)
            feel = itemView.findViewById(R.id.feel)


            /*itemView.setOnClickListener {
                lastSelectedPosition = adapterPosition
                notifyDataSetChanged()
            }*/
        }
    }



}
