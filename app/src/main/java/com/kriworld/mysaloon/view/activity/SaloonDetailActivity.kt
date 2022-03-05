package com.kriworld.mysaloon.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.RecyclerView.RecommendAdaptor
import com.kriworld.mysaloon.RecyclerView.SaloonImageViewAdaptor
import com.kriworld.mysaloon.databinding.ActivitySaloonDetailBinding
import com.kriworld.mysaloon.model.HomeBannerModel
import me.relex.circleindicator.CircleIndicator3
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask

class SaloonDetailActivity : AppCompatActivity() {
    private lateinit var saloonDetailBinding: ActivitySaloonDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        saloonDetailBinding = ActivitySaloonDetailBinding.inflate(layoutInflater)
        setContentView(saloonDetailBinding.root)

       addbanner()



        saloonDetailBinding.backButton.setOnClickListener {
            onBackPressed()
        }

        saloonDetailBinding.recommendList.adapter = RecommendAdaptor(this)
    }


    fun addbanner(){

        val list = ArrayList<HomeBannerModel>()
        for (i in 1..2){
            list.add(HomeBannerModel(R.drawable.salonn_image_one))
            list.add(HomeBannerModel(R.drawable.saloon_image_four))
        }

        saloonDetailBinding.detailViewpager.adapter= SaloonImageViewAdaptor(this,list)
        val indicator3 = findViewById<CircleIndicator3>(R.id.detail_indicator)
        indicator3.setViewPager(saloonDetailBinding.detailViewpager)

        val timer = Timer()
        val handler= Handler()
        timer.schedule(timerTask {
                       handler.post(Runnable(){
                           var i = saloonDetailBinding.detailViewpager.currentItem

                            if (i== list.size-1){
                                i = 0;
                                saloonDetailBinding.detailViewpager.setCurrentItem(i,true)
                            }else{
                                i++
                                saloonDetailBinding.detailViewpager.setCurrentItem(i,true)
                            }
                       })
        },4000,4000)
    }
}