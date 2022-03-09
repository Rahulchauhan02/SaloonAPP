package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.model.BookingSaloonListModel
import com.kriworld.mysaloon.view.activity.SaloonDetailActivity

class SaloonBookingAdaptor(val list:ArrayList<BookingSaloonListModel>, val context: Context):RecyclerView.Adapter<SaloonBookingAdaptor.BookingSaloonViewHolder>() {

    class BookingSaloonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val saloon_name = itemView.findViewById<TextView>(R.id.booking_saloon_name)
        val rating = itemView.findViewById<TextView>(R.id.booking_saloon_rating)
        val distance = itemView.findViewById<TextView>(R.id.booking_saloon_distance)
        val saloon_image = itemView.findViewById<ImageView>(R.id.booking_saloon_image)
        val services = itemView.findViewById<TextView>(R.id.booking_saloon_services)
        val area = itemView.findViewById<TextView>(R.id.booking_saloon_area)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingSaloonViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.booking_saloon_single_item,parent,false)
        return BookingSaloonViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BookingSaloonViewHolder, position: Int) {
        holder.area.text = list[position].area
        holder.distance.text = list[position].distance
        holder.rating.text = list[position].rating
        holder.saloon_name.text = list[position].name
        holder.services.text = list[position].services


        holder.itemView.setOnClickListener {
           val intent = Intent(context,SaloonDetailActivity::class.java)
           it.context.startActivity(intent)
       }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}