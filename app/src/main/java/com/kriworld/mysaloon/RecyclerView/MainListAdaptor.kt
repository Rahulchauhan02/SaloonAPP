package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.model.MainListModel

class MainListAdaptor(val context: Context,val list:ArrayList<MainListModel>):RecyclerView.Adapter<MainListAdaptor.MainViewHolder>()
{

    class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.main_list_name)
        val recyclerlist = itemView.findViewById<RecyclerView>(R.id.subRecyclerList)
        val downArrow = itemView.findViewById<ImageView>(R.id.downArrowBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.main_list_single_item,parent,false)
        return MainViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.title.text = "${list[position].title} (${list[position].sublist.size})"
        holder.recyclerlist.adapter = SubListAdaptor(list[position].sublist,context)
        var state = 1
        holder.downArrow.setOnClickListener {
          if(state == 1){
              holder.recyclerlist.visibility = View.VISIBLE
               state = 2
              holder.downArrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
          }
            else{

                holder.recyclerlist.visibility = View.GONE
              state=1
              holder.downArrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)

            }

        }
         holder.title.setOnClickListener {
          if(state == 1){
              holder.recyclerlist.visibility = View.VISIBLE
               state = 2
              holder.downArrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
          }
            else{

                holder.recyclerlist.visibility = View.GONE
              state=1
              holder.downArrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)

            }

        }

    }

    override fun getItemCount(): Int {
       return  list.size
    }


}