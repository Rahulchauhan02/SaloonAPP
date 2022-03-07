package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.model.MainListModel

class MainListAdaptor(val context: Context,val list:ArrayList<MainListModel>):RecyclerView.Adapter<MainListAdaptor.MainViewHolder>()
{

    class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.main_list_name)
        val recyclerlist = itemView.findViewById<RecyclerView>(R.id.subRecyclerList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.main_list_single_item,parent,false)
        return MainViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.recyclerlist.adapter = SubListAdaptor(list[position].sublist,context)
    }

    override fun getItemCount(): Int {
       return  list.size
    }


}