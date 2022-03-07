package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.model.SubListModel


class SubListAdaptor(val list:ArrayList<SubListModel>, val context: Context):RecyclerView.Adapter<SubListAdaptor.RecommendViewHolder>() {
    class RecommendViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val name = itemView.findViewById<TextView>(R.id.saloon_item_name)
        val description = itemView.findViewById<TextView>(R.id.saloon_item_details)
        val price = itemView.findViewById<TextView>(R.id.saloon_item_price)
        val type = itemView.findViewById<TextView>(R.id.saloon_item_type)
        val image = itemView.findViewById<ImageView>(R.id.saloon_item_image)
        val button = itemView.findViewById<Button>(R.id.saloon_item_add_btn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
       val layout = LayoutInflater.from(context).inflate(R.layout.subli_list_single_item,parent,false)
        return RecommendViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
      holder.name.text = list[position].itemName
        holder.description.text = list[position].itemDescription
        holder.price.text = list[position].itemPrice
        holder.type.text = list[position].itemType
        Glide.with(context)
            .load(list[position].itemImage)
            .into(holder.image)


        holder.button.setOnClickListener {
            Toast.makeText(context,"you added ${holder.name.text}",Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
       return list.size
    }
}