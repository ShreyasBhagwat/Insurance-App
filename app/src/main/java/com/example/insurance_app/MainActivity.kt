package com.example.insurance_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var userName=EditText(this)
        var userPasswkord=EditText(this)
        val loginbtn=Button(this)
        val signup=Button(this)

        if(userName.text.trim().equals("Admin")&&userPasswkord.text.equals("admin")){
            startActivity(Intent(this@MainActivity,signup::class.java))
        }else{
            startActivity(Intent(this@MainActivity,signup::class.java))
        }
    }
}