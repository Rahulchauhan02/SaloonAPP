package com.kriworld.mysaloon.view.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kriworld.mysaloon.databinding.ActivitySaloonDetailBinding


class SaloonDetailActivity : AppCompatActivity() {
    private lateinit var saloonDetailBinding: ActivitySaloonDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        saloonDetailBinding = ActivitySaloonDetailBinding.inflate(layoutInflater)
        setContentView(saloonDetailBinding.root)

        setSupportActionBar(saloonDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        saloonDetailBinding.toolbar.title =" "
        saloonDetailBinding.toolbar.setNavigationOnClickListener {

            onBackPressed()
        }







    }

    override fun onBackPressed() {
        super.onBackPressed()

    }


}