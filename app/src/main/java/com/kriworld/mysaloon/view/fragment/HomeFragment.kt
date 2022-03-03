package com.kriworld.mysaloon.view.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.RecyclerView.BannerAdaptor
import com.kriworld.mysaloon.databinding.FragmentHomeBinding
import com.kriworld.mysaloon.model.HomeBannerModel
import me.relex.circleindicator.CircleIndicator3
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask


@Suppress("DEPRECATION")
class HomeFragment : Fragment() {
 private lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     homeBinding = FragmentHomeBinding.inflate(layoutInflater)

          aNavigationDrawer()
            AddBannerList()




        return homeBinding.root
    }



    fun aNavigationDrawer(){
          val toggle:ActionBarDrawerToggle = ActionBarDrawerToggle(requireActivity(),homeBinding.drawerLayout,R.string.open,R.string.close)
     homeBinding.drawerLayout.addDrawerListener(toggle)
     toggle.syncState()




        requireActivity()
            .onBackPressedDispatcher
            .addCallback(this.viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (homeBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        homeBinding.drawerLayout.closeDrawer(GravityCompat.START)
                    } else {
                        if (isEnabled) {
                            isEnabled = false
                            requireActivity().onBackPressed()
                        }
                    }
                }
            }
        )


        homeBinding.navMenu.setOnClickListener {
            homeBinding.drawerLayout.openDrawer(GravityCompat.START)
        }

    }

    fun AddBannerList(){

        val list= ArrayList<HomeBannerModel>()
        for(i in 1..3){
            list.add(HomeBannerModel(R.drawable.banner_one))
            list.add(HomeBannerModel(R.drawable.banner_two))
            list.add(HomeBannerModel(R.drawable.banner_three))

        }

        homeBinding.bannerList.adapter = BannerAdaptor(list,requireContext())
        val indicator:CircleIndicator3 = homeBinding.indicator
        indicator.setViewPager(homeBinding.bannerList)

        val timer = Timer()
        val handler = Handler()

        timer.schedule(
            timerTask {
                handler.post(
                    Runnable(){
                       var  i = homeBinding.bannerList.currentItem
                        if (i == list.size-1){
                            i = 0
                            homeBinding.bannerList.setCurrentItem(i,true)
                        }else{
                            i++
                            homeBinding.bannerList.setCurrentItem(i,true)
                        }
                    }
                )
            },5000,5000
        )


    }




}