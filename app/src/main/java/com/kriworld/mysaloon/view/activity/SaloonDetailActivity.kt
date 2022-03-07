package com.kriworld.mysaloon.view.activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.ViewGroup
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.RecyclerView.BrowserListAdaptor
import com.kriworld.mysaloon.RecyclerView.RecommendAdaptor
import com.kriworld.mysaloon.RecyclerView.SaloonImageViewAdaptor
import com.kriworld.mysaloon.databinding.ActivitySaloonDetailBinding
import com.kriworld.mysaloon.databinding.BrowseItemDialogBinding
import com.kriworld.mysaloon.model.BrowseItemModel
import com.kriworld.mysaloon.model.HomeBannerModel
import com.kriworld.mysaloon.model.RecommendedListModel
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

        addBanner()
        addRecommendList()

        saloonDetailBinding.backButton.setOnClickListener {
            onBackPressed()
        }


        saloonDetailBinding.browseItem.setOnClickListener {
            showBrowserItemDialog()

        }





    }


    fun addBanner(){

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

    fun addRecommendList(){

        val list = ArrayList<RecommendedListModel>()
        val femaleList = ArrayList<RecommendedListModel>()
        val maleList = ArrayList<RecommendedListModel>()


        for (i in 0..5){
            list.add(RecommendedListModel("item$i","description$i",
            "${45+i}","Female",R.drawable.banner_one))
             list.add(RecommendedListModel("item$i","description$i",
            "${45+i}","Male",R.drawable.banner_one))
        }



        for (i in 0..list.size-1)
        {
            if (list[i].itemType == "Female"){
                femaleList.add(list[i])
            }

             if (list[i].itemType == "Male"){
                maleList.add(list[i])
            }


        }
         saloonDetailBinding.recommendList.adapter = RecommendAdaptor(list,this)


        saloonDetailBinding.femaleSwitch.setOnCheckedChangeListener {_, isChecked ->
            if (isChecked){
                 saloonDetailBinding.maleSwitch.isChecked = false
                saloonDetailBinding.recommendList.adapter = RecommendAdaptor(femaleList,this)

            }
            else {
                saloonDetailBinding.recommendList.adapter = RecommendAdaptor(list,this)
            }
        }


        saloonDetailBinding.maleSwitch.setOnCheckedChangeListener {_, isChecked ->
              if (isChecked){
                     saloonDetailBinding.femaleSwitch.isChecked = false
                saloonDetailBinding.recommendList.adapter = RecommendAdaptor(maleList,this)

            }
              else {
                saloonDetailBinding.recommendList.adapter = RecommendAdaptor(list,this)
            }
        }


    }


    fun showBrowserItemDialog(){
     val dialog = Dialog(this)
     val binding = BrowseItemDialogBinding.inflate(layoutInflater)
     dialog.setContentView(binding.root)
       dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
       dialog.window?.setGravity(Gravity.BOTTOM)
        dialog.show()

        val list = ArrayList<BrowseItemModel>()
        list.add(BrowseItemModel("Haircut"))
         list.add(BrowseItemModel("Waxing"))
         list.add(BrowseItemModel("Hair Color"))
          list.add(BrowseItemModel("Massage"))
         list.add(BrowseItemModel("spa"))
        binding.dialogList.adapter = BrowserListAdaptor(list,this)

    }

}