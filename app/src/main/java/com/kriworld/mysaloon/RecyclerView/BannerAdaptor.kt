package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.model.HomeBannerModel

class BannerAdaptor(val list:ArrayList<HomeBannerModel>,val context: Context)
    : RecyclerView.Adapter<BannerAdaptor.BannerViewHolder>(){
  inner class  BannerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
      val image = itemView.findViewById<ImageView>(R.id.banner_image)
  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.home_banner,parent,false)
        return BannerViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {

        Glide.with(context)
            .load(list[position].image)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
      return list.size
    }
}