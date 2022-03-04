package com.kriworld.mysaloon.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.databinding.FragmentProfileBinding
import com.kriworld.mysaloon.databinding.FragmentProfileDetailsBinding


class ProfileDetailsFragment : Fragment() {
private lateinit var profileDetailsFragment: FragmentProfileDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       profileDetailsFragment = FragmentProfileDetailsBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).setSupportActionBar(profileDetailsFragment.editProfileToolbar)
        setHasOptionsMenu(true)



        return profileDetailsFragment.root
    }


}