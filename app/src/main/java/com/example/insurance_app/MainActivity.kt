package com.example.insurance_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.insurance_app.data.InsuranceDatabase
import com.example.insurance_app.data.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,InsuranceDatabase::class.java,"insurance_database"
        ).build()



        GlobalScope.launch {

            InsuranceDatabase.getInstance(applicationContext)

            db.userDao().insert(User(101,"Shreyas","Bhopal","7987685319","bhagwatshreyas01@gmail.com",1))
            db.userDao().insert(User(102,"Dhruv","Surat","9726278998","bhagwatshreyas01@gmail.com",0))
        }
    }
}