package com.kriworld.mysaloon.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.RecyclerView.SaloonBookingAdaptor
import com.kriworld.mysaloon.databinding.FragmentBookingBinding


class BookingFragment : Fragment() {
   private lateinit var bookingBinding: FragmentBookingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      bookingBinding = FragmentBookingBinding.inflate(layoutInflater)

        bookingBinding.bookingSaloonList.adapter = SaloonBookingAdaptor(requireActivity())

        bookingBinding.locationBtn.setOnClickListener {
            getLocationPermission()
        }

        bookingBinding.locationTextBtn.setOnClickListener {
            getLocationPermission()
        }





        return bookingBinding.root
    }




    fun getLocationPermission(){

        Dexter.withContext(requireActivity())
            .withPermissions(android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION)
            .withListener(object :MultiplePermissionsListener{
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                    p0?.let {
                    if(p0.areAllPermissionsGranted()){
                         Toast.makeText(requireContext(),"Location Permission granted",Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    p1: PermissionToken?
                ) {
                    p1?.continuePermissionRequest()
                }
            }).onSameThread().check()

    }



}