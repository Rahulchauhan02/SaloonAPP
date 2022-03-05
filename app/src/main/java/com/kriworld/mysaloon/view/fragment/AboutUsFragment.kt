package com.kriworld.mysaloon.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.databinding.FragmentAboutUsBinding


class AboutUsFragment : Fragment() {

 private lateinit var aboutUsBinding: FragmentAboutUsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutUsBinding = FragmentAboutUsBinding.inflate(layoutInflater)

        aboutUsBinding.backAbout.setOnClickListener {
            findNavController().navigate(R.id.action_aboutUsFragment_to_profileFragment)
        }



        return aboutUsBinding.root
    }


}