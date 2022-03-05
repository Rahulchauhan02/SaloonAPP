package com.kriworld.mysaloon.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.databinding.FragmentNeedHelpBinding


class NeedHelpFragment : Fragment() {

  private lateinit var needHelpBinding: FragmentNeedHelpBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        needHelpBinding = FragmentNeedHelpBinding.inflate(layoutInflater)

        needHelpBinding.backNeed.setOnClickListener {
            findNavController().navigate(R.id.action_needHelpFragment_to_profileFragment)
        }


        return needHelpBinding.root
    }


}