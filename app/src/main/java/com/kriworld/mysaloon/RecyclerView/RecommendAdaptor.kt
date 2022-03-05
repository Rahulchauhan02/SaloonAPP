package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kriworld.mysaloon.R

class RecommendAdaptor(val context: Context):RecyclerView.Adapter<RecommendAdaptor.RecommendViewHolder>() {
    class RecommendViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
       val layout = LayoutInflater.from(context).inflate(R.layout.recommend_list_item,parent,false)
        return RecommendViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return 10
    }
}