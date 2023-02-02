package com.example.insurance_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EnterUserDetalis : AppCompatActivity() {
    lateinit var carNumber:EditText
    lateinit var carCompany:EditText
    lateinit var carModel:EditText
    lateinit var carEngineNumber:EditText
    lateinit var carChassisNumber:EditText
    lateinit var carYearOfMgf:EditText
    lateinit var carFuelType:EditText
    lateinit var btnContinue:Button
    lateinit var carDetalisArray:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_user_detalis)
        carNumber=findViewById(R.id.carNumber)
        carCompany=findViewById(R.id.carComapny)
        carModel=findViewById(R.id.carModel)
        carEngineNumber=findViewById(R.id.engineNumber)
        carChassisNumber=findViewById(R.id.chassisNumber)
        carYearOfMgf=findViewById(R.id.yearOfMfg)
        carFuelType=findViewById(R.id.fuelType)
        btnContinue=findViewById(R.id.btn_continue)

        btnContinue.setOnClickListener {
            if (TextUtils.isEmpty(carNumber.text.toString())) {
                Toast.makeText(this, "Car's number is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else if (TextUtils.isEmpty(carCompany.text.toString())) {
                Toast.makeText(this, "Car's Company is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else if (TextUtils.isEmpty(carModel.text.toString())) {
                Toast.makeText(this, "Car's Model is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else  if (TextUtils.isEmpty(carEngineNumber.text.toString())) {
                Toast.makeText(this, "Car's Engine number is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else  if (TextUtils.isEmpty(carChassisNumber.text.toString())) {
                Toast.makeText(this, "Car's Chassis number is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else  if (TextUtils.isEmpty(carYearOfMgf.text.toString())) {
                Toast.makeText(this, "Car's Year of Manufacturing date is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else if(TextUtils.isEmpty(carFuelType.text.toString())) {
                Toast.makeText(this, "Car's Fuel type is mandatory field", Toast.LENGTH_SHORT).show()
            }
            else{
                carDetalisArray= arrayOf(carNumber.text.toString(),carCompany.text.toString(),carModel.text.toString(),carEngineNumber.text.toString(),carChassisNumber.text.toString(),carYearOfMgf.text.toString(),carFuelType.text.toString())
                for(i in carDetalisArray){
                    Log.d("EnterUserDetails ",i)
                }
                startActivity(Intent(this,PolicyList::class.java))
            }
        }
    }
}