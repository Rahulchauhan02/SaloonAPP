package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.model.OfferModel

class OfferAdaptor(val list:ArrayList<OfferModel>,val context: Context): RecyclerView.Adapter<OfferAdaptor.OfferViewHolder>() {

inner class OfferViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
 val image = itemView.findViewById<ImageView>(R.id.offer_image)
 val offer = itemView.findViewById<TextView>(R.id.offer_text)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.offer_single_item,parent,false)
        return OfferViewHolder(layout)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        Glide.with(context)
            .load(list[position].image)
            .into(holder.image)

        holder.offer.text = list[position].offerText
    }

    override fun getItemCount(): Int {
        return 8
    }

}