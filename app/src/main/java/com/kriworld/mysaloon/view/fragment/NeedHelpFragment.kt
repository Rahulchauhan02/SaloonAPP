package com.kriworld.mysaloon.view.fragment

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.databinding.BrowseItemDialogBinding
import com.kriworld.mysaloon.databinding.FragmentNeedHelpBinding
import com.kriworld.mysaloon.databinding.QueryServicesBinding


class NeedHelpFragment : Fragment() {


  private lateinit var needHelpBinding: FragmentNeedHelpBinding


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        needHelpBinding = FragmentNeedHelpBinding.inflate(layoutInflater)

        needHelpBinding.needQueryType.setOnClickListener {
            showDialog()
        }
        needHelpBinding.query.setOnClickListener {
            showDialog()
        }
        needHelpBinding.query.setOnClickListener {
            showDialog()
        }
        needHelpBinding.backNeed.setOnClickListener {
            findNavController().navigate(R.id.action_needHelpFragment_to_profileFragment)
        }
        return needHelpBinding.root
    }



    //List of Services Dialog
    fun showDialog(){
        var dialog = Dialog(requireContext())

        val binding = QueryServicesBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setGravity(Gravity.CENTER)

        binding.serviceText.setOnClickListener {
            needHelpBinding.needQueryType.setText(binding.serviceText.text)
            dialog.dismiss()
        }
        binding.bookingText.setOnClickListener {

            needHelpBinding.needQueryType.setText(binding.bookingText.text)
            dialog.dismiss()
        }
        binding.cancellationText.setOnClickListener {
            needHelpBinding.needQueryType.setText(binding.cancellationText.text)
            dialog.dismiss()
        }
        binding.refundText.setOnClickListener {
            needHelpBinding.needQueryType.setText(binding.refundText.text)
            dialog.dismiss()
        }
        binding.AccountCreationText.setOnClickListener {
            needHelpBinding.needQueryType.setText(binding.AccountCreationText.text)
            dialog.dismiss()
        }
        binding.partnerAffiliationText.setOnClickListener {
            needHelpBinding.needQueryType.setText(binding.partnerAffiliationText.text)
            dialog.dismiss()
        }

    }





}