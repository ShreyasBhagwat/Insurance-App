package com.example.insurance_app

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class EnterDetails : AppCompatActivity() {
//    lateinit var ItemNumberPreview:EditText
    lateinit var ItemNumber:EditText
    lateinit var vehicleCompany:EditText
    lateinit var vehicleModel:EditText
    lateinit var vehicleEngineNumber:EditText
    lateinit var vehicleChassisNumber:EditText
    lateinit var vehicleYearOfMgf:EditText
    lateinit var btnContinue:Button
    lateinit var petrolCardView:CardView
    lateinit var dieselCardView:CardView
    lateinit var cngCardView:CardView
    lateinit var carDetalisArray:Array<String>
    lateinit var fuleTypeLayout:LinearLayout
    lateinit var titleDetalis:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_user_detalis)
//        ItemNumberPreview=findViewById(R.id.carNumberPreview)
        ItemNumber=findViewById(R.id.carNumber)
        vehicleCompany=findViewById(R.id.carComapny)
        vehicleModel=findViewById(R.id.carModel)
        vehicleEngineNumber=findViewById(R.id.engineNumber)
        vehicleChassisNumber=findViewById(R.id.chassisNumber)
        vehicleYearOfMgf=findViewById(R.id.yearOfMfg)
        btnContinue=findViewById(R.id.btn_continue)
        fuleTypeLayout=findViewById(R.id.fuelTypeLinerLayout)
        petrolCardView=findViewById(R.id.petrolCardView)
        dieselCardView=findViewById(R.id.dieselCardView)
        cngCardView=findViewById(R.id.CNGCardView)
        titleDetalis=findViewById(R.id.enterDetails)
        val intent = intent
        val str = intent.getStringExtra("Vehicle")
        if(str=="Bike"||str=="Mobile"){
            fuleTypeLayout.visibility=View.GONE
            titleDetalis.text="Compare and save money on bike Insurance"
            if(str=="Mobile"){
                titleDetalis.text="Compare and save money on mobile Insurance"
                ItemNumber.visibility=View.GONE
                vehicleChassisNumber.visibility=View.GONE
                vehicleEngineNumber.visibility=View.GONE
            }
        }
        var sharedPreferences:SharedPreferences=getSharedPreferences("numberPlate", MODE_PRIVATE)
        var sharedPreferencesEditor: SharedPreferences.Editor
        val vehicleNumber: String? =sharedPreferences.getString("number","")

        ItemNumber.setText(vehicleNumber)
        sharedPreferencesEditor=sharedPreferences.edit()
        sharedPreferencesEditor.clear()
        sharedPreferencesEditor.apply()
        btnContinue.setOnClickListener {
            if (TextUtils.isEmpty(ItemNumber.text.toString())&&str!="Mobile") {
                Toast.makeText(this, "Car's number is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else if (TextUtils.isEmpty(vehicleCompany.text.toString())) {
                Toast.makeText(this, "Car's Company is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else if (TextUtils.isEmpty(vehicleModel.text.toString())) {
                Toast.makeText(this, "Car's Model is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else  if (TextUtils.isEmpty(vehicleEngineNumber.text.toString())&&str!="Mobile") {
                Toast.makeText(this, "Car's Engine number is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else  if (TextUtils.isEmpty(vehicleChassisNumber.text.toString())&&str!="Mobile") {
                Toast.makeText(this, "Car's Chassis number is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else  if (TextUtils.isEmpty(vehicleYearOfMgf.text.toString())) {
                Toast.makeText(this, "Car's Year of Manufacturing date is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else{
                carDetalisArray= arrayOf(ItemNumber.text.toString(),vehicleCompany.text.toString(),vehicleModel.text.toString(),vehicleEngineNumber.text.toString(),vehicleChassisNumber.text.toString(),vehicleYearOfMgf.text.toString())
                for(i in carDetalisArray){
                    Log.d("EnterUserDetails ",i)
                }

                startActivity(Intent(this,PolicyList::class.java))
            }
        }
    }
}