package com.kriworld.mysaloon.view.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.LocationManager
import android.location.LocationRequest
import android.media.audiofx.Equalizer
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.RecyclerView.SaloonBookingAdaptor
import com.kriworld.mysaloon.databinding.FragmentBookingBinding
import com.kriworld.mysaloon.model.BookingSaloonListModel
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import java.util.*
import java.util.jar.Manifest
import kotlin.collections.ArrayList


class BookingFragment : Fragment(),EasyPermissions.PermissionCallbacks {
   private lateinit var bookingBinding: FragmentBookingBinding
   private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
 //  private lateinit var locationRequest: LocationRequest
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      bookingBinding = FragmentBookingBinding.inflate(layoutInflater)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext())


        val list =ArrayList<BookingSaloonListModel>()

        bookingBinding.bookingSaloonList.adapter = SaloonBookingAdaptor(list,requireActivity())


           if (!hasLocationpermission()) {
               requestLocationPermission()
           }else{
               getLocationData()
           }


       bookingBinding.locationTextBtn.setOnClickListener {
             if (!hasLocationpermission()) {
               requestLocationPermission()
           }else{
               Toast.makeText(requireContext(),"New Location Access is going on",Toast.LENGTH_SHORT).show()
               getLocationData()
           }
       }



        return bookingBinding.root
    }


       private fun hasLocationpermission():Boolean {


           return  EasyPermissions.hasPermissions(requireContext(),android.Manifest.permission.ACCESS_COARSE_LOCATION,
           android.Manifest.permission.ACCESS_FINE_LOCATION)
       }


        private fun requestLocationPermission(){
            EasyPermissions.requestPermissions(this,"This Application Cannot work without Location"
           , 5 ,android.Manifest.permission.ACCESS_COARSE_LOCATION,
           android.Manifest.permission.ACCESS_FINE_LOCATION )

        }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
       getLocationData()
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
       if (EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
           AppSettingsDialog.Builder(requireActivity()).build().show()
       }else{
           requestLocationPermission()
       }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode,permissions,grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this)
    }


    @SuppressLint("MissingPermission")
    fun getLocationData(){

        if(isLocationEnabled()){


                fusedLocationProviderClient.lastLocation.addOnCompleteListener { task ->
                    var location = task.result
                    if (location==null){}
                    else{
                       var lat = location.latitude
                       var long = location.longitude
                       var geocoder = Geocoder(requireContext(), Locale.getDefault())
                       var address = geocoder.getFromLocation(lat,long,1)
                       bookingBinding.locationTextBtn.text ="${address.get(0).subLocality}, ${address.get(0).locality}"

                    }

                }

        }else{

            Toast.makeText(requireContext(),"Please Enable your location services ",Toast.LENGTH_SHORT).show()
        }


    }

    fun isLocationEnabled():Boolean{
        var locationManager = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

}