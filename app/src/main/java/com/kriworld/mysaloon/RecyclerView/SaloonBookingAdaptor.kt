package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.kriworld.mysaloon.R

class SaloonBookingAdaptor(val context: Context):RecyclerView.Adapter<SaloonBookingAdaptor.BookingSaloonViewHolder>() {

    class BookingSaloonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingSaloonViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.booking_saloon_single_item,parent,false)
        return BookingSaloonViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BookingSaloonViewHolder, position: Int) {
       holder.itemView

    }

    override fun getItemCount(): Int {
        return 10
    }

}