package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.model.BrowseItemModel
import com.kriworld.mysaloon.model.MainListModel

class BrowserListAdaptor(val list:ArrayList<MainListModel>,val context: Context):RecyclerView.Adapter<BrowserListAdaptor.BrowseViewholder>() {

    class BrowseViewholder(itemView:View):RecyclerView.ViewHolder(itemView){
      val item_name = itemView.findViewById<TextView>(R.id.browse_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrowseViewholder {
        val layout = LayoutInflater.from(context).inflate(R.layout.browse_single_item,parent,false)
        return BrowseViewholder(layout)
    }

    override fun onBindViewHolder(holder: BrowseViewholder, position: Int) {
        holder.item_name.text = "${list[position].title} (${list[position].sublist.size})"

        holder.itemView.setOnClickListener {

        }


    }

    override fun getItemCount(): Int {
       return list.size
    }


}