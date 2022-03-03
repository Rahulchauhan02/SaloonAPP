package com.kriworld.mysaloon.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kriworld.mysaloon.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
   private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.loginPageBtn.setOnClickListener {
            val intent = Intent(this,UserRegisterActivity::class.java)
            startActivity(intent)
        }



    }
}