package com.kriworld.mysaloon.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.constants.Constants
import com.kriworld.mysaloon.model.ProfileMenuModel

class ProfileMenuListAdaptor(val list: ArrayList<ProfileMenuModel>,val context: Context):RecyclerView.Adapter<ProfileMenuListAdaptor.ProfileViewHolder>() {



    class ProfileViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var icon_image = itemView.findViewById<ImageView>(R.id.icon_image)
        val text_title = itemView.findViewById<TextView>(R.id.profile_menu_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
       val layout = LayoutInflater.from(context).inflate(R.layout.profile_layout_menu_item,parent,false)
        return  ProfileViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        Glide.with(context)
            .load(list[position].image)
            .circleCrop()
            .into(holder.icon_image)
        holder.text_title.text = list[position].title



      holder.itemView.setOnClickListener {
          when(holder.text_title.text){

              "Rojkaa Points" ->  it.findNavController().navigate(R.id.action_profileFragment_to_rajkaaPointsFragment)

               "Booking"  -> it.findNavController().navigate(R.id.action_profileFragment_to_myBookingFragment)

                "Invite and Earn" ->  it.findNavController().navigate(R.id.action_profileFragment_to_inviteFragment)

              "Need Help" -> it.findNavController().navigate(R.id.action_profileFragment_to_needHelpFragment)

              "Register as Partner" -> it.findNavController().navigate(R.id.action_profileFragment_to_registerAsPartner)

              "Terms and Conditions" -> it.findNavController().navigate(R.id.action_profileFragment_to_termsAndConditionFragment)

              "About Us" -> it.findNavController().navigate(R.id.action_profileFragment_to_aboutUsFragment)



          }
      }




    }

    override fun getItemCount(): Int {
      return list.size
    }
}