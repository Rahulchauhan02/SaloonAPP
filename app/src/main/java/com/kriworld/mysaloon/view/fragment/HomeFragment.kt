package com.kriworld.mysaloon.view.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.RecyclerView.BannerAdaptor
import com.kriworld.mysaloon.databinding.FragmentHomeBinding
import com.kriworld.mysaloon.model.HomeBannerModel
import me.relex.circleindicator.CircleIndicator2
import me.relex.circleindicator.CircleIndicator3
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask


@Suppress("DEPRECATION")
class HomeFragment : Fragment() {
 private lateinit var homeBinding: FragmentHomeBinding
 private lateinit var timer:Timer
 private lateinit var handler:Handler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        timer = Timer()
        handler = Handler()

        val list = ArrayList<HomeBannerModel>()
        for (i in 0..2){
            list.add(HomeBannerModel(R.drawable.banner_one))
             list.add(HomeBannerModel(R.drawable.banner_two))
             list.add(HomeBannerModel(R.drawable.banner_three))
        }

        homeBinding.viewPager.adapter = BannerAdaptor(list,requireActivity())
        val indicator:CircleIndicator3 = homeBinding.circleIndicator
        indicator.setViewPager(homeBinding.viewPager)

        timer.schedule(timerTask {

                handler.post(Runnable(){
                    var i = homeBinding.viewPager.currentItem
                    if (i==list.size-1){
                        i = 0
                        homeBinding.viewPager.setCurrentItem(i,true)
                    }else{
                        i++
                        homeBinding.viewPager.setCurrentItem(i,true)
                    }
                }
                )
                                 },4000,4000)








        return homeBinding.root
    }


}