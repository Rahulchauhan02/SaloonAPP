package com.kriworld.mysaloon.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kriworld.mysaloon.R
import com.kriworld.mysaloon.databinding.ActivityUserRegisterBinding

class UserRegisterActivity : AppCompatActivity() {
    private lateinit var userRegisterBinding: ActivityUserRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userRegisterBinding = ActivityUserRegisterBinding.inflate(layoutInflater)
        setContentView(userRegisterBinding.root)

        userRegisterBinding.registerBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }

    }
}