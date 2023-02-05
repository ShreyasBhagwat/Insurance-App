package com.example.insurance_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog

class PolicyList : AppCompatActivity() {
    lateinit var seeMore:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy_list)
       seeMore=findViewById(R.id.seeMore)
       seeMore.setOnClickListener{
           val view = layoutInflater.inflate(R.layout.detail_policy_drawer, null)
           val dialog = BottomSheetDialog(this)
           dialog.setCancelable(true)
           dialog.setContentView(view)
           dialog.show()
       }
    }
}