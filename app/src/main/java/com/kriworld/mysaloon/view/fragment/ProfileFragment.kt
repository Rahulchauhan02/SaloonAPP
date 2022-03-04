package com.kriworld.mysaloon.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.RecyclerView.ProfileMenuListAdaptor
import com.kriworld.mysaloon.databinding.FragmentProfileBinding
import com.kriworld.mysaloon.model.ProfileMenuModel


class ProfileFragment : Fragment() {
    private lateinit var profileBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       profileBinding = FragmentProfileBinding.inflate(layoutInflater)

       Glide.with(requireContext())
           .load(R.drawable.image_profile)
           .circleCrop()
           .into(profileBinding.profileImage)

       profileBinding.profileImage.setOnClickListener {
           findNavController().navigate(R.id.action_profileFragment_to_profileDetailsFragment)
       }
        profileBinding.userProfileName.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileDetailsFragment)
        }
        profileBinding.nextIcon.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileDetailsFragment)
        }
       profileBinding.editProfileBtn.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_profileDetailsFragment)
        }





       profileMenu()




        return profileBinding.root
    }











    fun profileMenu(){
         val PROFILE_MENU_LIST = ArrayList<ProfileMenuModel>()
        PROFILE_MENU_LIST.add(ProfileMenuModel(R.drawable.show_icon,"Rojkaa Points"))
       PROFILE_MENU_LIST.add(ProfileMenuModel(R.drawable.booking_icon,"Booking"))
       PROFILE_MENU_LIST.add(ProfileMenuModel(R.drawable.invite_icon,"Invite and Earn"))
       PROFILE_MENU_LIST.add(ProfileMenuModel(R.drawable.help_icon,"Need Help"))
       PROFILE_MENU_LIST.add(ProfileMenuModel(R.drawable.register_icon,"Register as Partner"))
       PROFILE_MENU_LIST.add(ProfileMenuModel(R.drawable.trems_icon,"Terms and Conditions"))
       PROFILE_MENU_LIST.add(ProfileMenuModel(R.drawable.about_icon,"About Us"))


        profileBinding.profileListMenu.adapter = ProfileMenuListAdaptor(PROFILE_MENU_LIST,requireActivity())
    }

}