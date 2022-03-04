package com.kriworld.mysaloon.view.fragment

import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.constants.Constants
import com.kriworld.mysaloon.databinding.CamerGalleryDialogBinding
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


        profileDetailsFragment.imageSelect.setOnClickListener {
            hasPermissionGranted()
        }





        return profileDetailsFragment.root
    }

    fun hasPermissionGranted(){

        Dexter.withContext(requireActivity())
            .withPermissions(android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.CAMERA)
            .withListener(object : MultiplePermissionsListener{
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                    p0?.let {
                        if (p0.areAllPermissionsGranted()){
                            showDialog()
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    p1: PermissionToken?
                ) {
                    Toast.makeText(requireContext(),"Permission denied go to settings",Toast.LENGTH_SHORT).show()
                    p1?.continuePermissionRequest()

                }
            }).onSameThread().check()



    }



    fun showDialog(){

      val dialogBinding = CamerGalleryDialogBinding.inflate(layoutInflater)
      val dialog = Dialog(requireContext())
      dialog.setContentView(dialogBinding.root)
      dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
       dialog.window?.setGravity(Gravity.BOTTOM)
        dialog.show()


        dialogBinding.camera.setOnClickListener {

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,Constants.CAMERA_CODE)
            dialog.dismiss()
        }

        dialogBinding.gallery.setOnClickListener {
          val intent = Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
           startActivityForResult(intent,Constants.GALLERY_CODE)
            dialog.dismiss()
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    if (requestCode== Constants.CAMERA_CODE){
        if (resultCode == RESULT_OK){
             data?.let {
                 val uri = data.extras?.get("data")
                 Glide.with(requireContext())
                     .load(uri)
                     .into(profileDetailsFragment.profileEditImage)
             }
        }

    }


         if (requestCode== Constants.GALLERY_CODE){
            if (resultCode == RESULT_OK){
             data?.let {
                 val uri = data.data
                Log.e("this",uri?.path.toString())
                 Glide.with(requireContext())
                     .load(uri)
                     .into(profileDetailsFragment.profileEditImage)
             }
        }

    }


    }




}