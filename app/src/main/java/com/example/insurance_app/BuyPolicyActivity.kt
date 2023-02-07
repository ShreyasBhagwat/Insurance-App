package com.example.insurance_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BuyPolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_policy)
        var cutPrice:TextView=findViewById(R.id.cutPrice)
        val offerPrice:TextView=findViewById(R.id.actualPrice)
        val buyButton:Button=findViewById(R.id.Buy)


        var i:Intent=intent
        var str = i.getStringExtra("ActualPrice")
        str= str?.subSequence(1,str.length).toString()
        var number: Int = str?.toInt() ?: 0
        number = (number+ number.times(0.4)).toInt()
        cutPrice.text=number.toString()
        offerPrice.text=str

        buyButton.setOnClickListener{
            Toast.makeText(this, "Thank you for choosing this policy", Toast.LENGTH_LONG).show()
            startActivity(Intent(this,UserDashboardActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        }
    }
}