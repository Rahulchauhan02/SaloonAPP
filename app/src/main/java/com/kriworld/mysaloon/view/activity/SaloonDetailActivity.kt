package com.kriworld.mysaloon.view.activity


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.ViewGroup
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.RecyclerView.BrowserListAdaptor
import com.kriworld.mysaloon.RecyclerView.MainListAdaptor
import com.kriworld.mysaloon.RecyclerView.SaloonImageViewAdaptor
import com.kriworld.mysaloon.databinding.ActivitySaloonDetailBinding
import com.kriworld.mysaloon.databinding.BrowseItemDialogBinding
import com.kriworld.mysaloon.model.BrowseItemModel
import com.kriworld.mysaloon.model.HomeBannerModel
import com.kriworld.mysaloon.model.MainListModel
import com.kriworld.mysaloon.model.SubListModel
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask


class SaloonDetailActivity : AppCompatActivity() {
    private lateinit var saloonDetailBinding: ActivitySaloonDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        saloonDetailBinding = ActivitySaloonDetailBinding.inflate(layoutInflater)
        setContentView(saloonDetailBinding.root)
        setSupportActionBar(saloonDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        saloonDetailBinding.toolbar.title = " "
        saloonDetailBinding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        saloonImageBanners()

       val itemlist = showItemList()



        saloonDetailBinding.browseItemBtn.setOnClickListener {
              showDialog(itemlist)

        }


    }

    override fun onBackPressed() {
        super.onBackPressed()

    }


    fun saloonImageBanners() {

        val list = ArrayList<HomeBannerModel>()

        list.add(HomeBannerModel(R.drawable.salonn_image_one))
        list.add(HomeBannerModel(R.drawable.banner_two))
        list.add(HomeBannerModel(R.drawable.banner_three))
        saloonDetailBinding.viewPager2.adapter = SaloonImageViewAdaptor(this, list)

        var i = saloonDetailBinding.viewPager2.currentItem

        Timer().schedule(
            timerTask {
                Handler(Looper.getMainLooper()).post(
                    Runnable() {
                        if (i == list.size - 1) {
                            i = 0;
                            saloonDetailBinding.viewPager2.setCurrentItem(i, true)
                        } else {
                            i++
                            saloonDetailBinding.viewPager2.setCurrentItem(i, true)
                        }
                    }
                )
            }, 4000, 4000
        )

    }


    fun showItemList() : ArrayList<MainListModel>{
        val sublist = ArrayList<SubListModel>()
        sublist.add(SubListModel("item 1", "Description 1", "50", "type 1", R.drawable.banner_one))
        sublist.add(SubListModel("item 2", "Description 2", "50", "type 2", R.drawable.salonn_image_one))
        sublist.add(
            SubListModel(
                "item 3",
                "Description 3",
                "50",
                "type 3",
                R.drawable.saloon_image_four
            )
        )
        val list = ArrayList<MainListModel>()
        list.add(MainListModel("Recommended", sublist))
        list.add(MainListModel("Menu item 1", sublist))
        list.add(MainListModel("Menu Item 2", sublist))
        list.add(MainListModel("Menu item 3", sublist))
        list.add(MainListModel("Menu Item 4", sublist))
        list.add(MainListModel("Menu item 5", sublist))
        list.add(MainListModel("Menu Item 6", sublist))
        list.add(MainListModel("Menu item 7", sublist))
         list.add(MainListModel("Menu item 8", sublist))
        list.add(MainListModel("Menu Item 9", sublist))
        list.add(MainListModel("Menu item 10", sublist))
           list.add(MainListModel("Menu item 11", sublist))
        list.add(MainListModel("Menu Item 12", sublist))
        list.add(MainListModel("Menu item 13", sublist))
           list.add(MainListModel("Menu item 14", sublist))
        list.add(MainListModel("Menu Item 15", sublist))
        list.add(MainListModel("Menu item 16", sublist))


        saloonDetailBinding.recyclerView.adapter = MainListAdaptor(this, list)


       return list
    }


    fun showDialog(list: ArrayList<MainListModel>) {

        val dialog = Dialog(this)
        val binding = BrowseItemDialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setGravity(Gravity.BOTTOM)
        dialog.show()
        binding.dialogList.adapter = BrowserListAdaptor(list, this)

    }

}