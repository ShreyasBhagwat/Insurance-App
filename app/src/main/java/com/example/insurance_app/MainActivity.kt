package com.example.insurance_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val singUp:TextView=findViewById(R.id.singUp)
        val logIn:TextView=findViewById(R.id.logIn)
        val singUpLayout:LinearLayout=findViewById(R.id.singUpLayout)
        val logInLayout:LinearLayout=findViewById(R.id.logInLayout)
        val singIn:Button=findViewById(R.id.singIn)

        singUp.setOnClickListener {
            singUp.background = resources.getDrawable(R.drawable.switch_trcks,null)
            singUp.setTextColor(resources.getColor(R.color.textColor,null))
            logIn.background = null

            singUpLayout.visibility = View.VISIBLE

            logInLayout.visibility = View.GONE
            logIn.setTextColor(resources.getColor(R.color.pinkColor,null))
        }
        logIn.setOnClickListener {
            singUp.background = null
            singUp.setTextColor(resources.getColor(R.color.pinkColor,null))
            logIn.background = resources.getDrawable(R.drawable.switch_trcks,null)
            singUpLayout.visibility = View.GONE
            logInLayout.visibility = View.VISIBLE
            logIn.setTextColor(resources.getColor(R.color.textColor,null))
        }
        singIn.setOnClickListener {
            startActivity(Intent(this@MainActivity,PolicyList::class.java))
        }
    }
}