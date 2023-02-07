package com.example.insurance_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handler = Handler()
        handler.postDelayed(Runnable { // TODO: Your application init goes here.
            val mInHome = Intent(this, LoginActivity::class.java)
            this.startActivity(mInHome)
            this.finish()
        }, 3000)
    }
}