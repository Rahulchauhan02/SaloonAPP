package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.model.HomeBannerModel

class SaloonImageViewAdaptor(val context:Context,val list:ArrayList<HomeBannerModel>):
RecyclerView.Adapter<SaloonImageViewAdaptor.SaloonIamgeViewHolder>(){

  class SaloonIamgeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val image = itemView.findViewById<ImageView>(R.id.saloon_image)
  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaloonIamgeViewHolder {
         val layout = LayoutInflater.from(context).inflate(R.layout.saloon_images_viewpager,parent,false)
        return SaloonIamgeViewHolder(layout)
    }

    override fun onBindViewHolder(holder: SaloonIamgeViewHolder, position: Int) {
        Glide.with(context)
            .load(list[position].image)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}