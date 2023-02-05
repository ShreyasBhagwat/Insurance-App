package com.example.insurance_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.insurance_app.data.InsuranceDatabase
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val insuranceDatabase by lazy{InsuranceDatabase.getDatabase(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val db = Room.databaseBuilder(
//            applicationContext,InsuranceDatabase::class.java,"insurance_database"
//        ).build()

        observePolicy()
    }

    private fun observePolicy() {
        lifecycleScope.launch {
            insuranceDatabase.policyDao().getAll()
        }
    }
}


//        GlobalScope.launch {
//
//            InsuranceDatabase.getDatabase(applicationContext)
//
////            db.userDao().insert(User(101,"Shreyas","Bhopal","7987685319","bhagwatshreyas01@gmail.com",1))
////            db.userDao().insert(User(102,"Dhruv","Surat","9726278998","bhagwatshreyas01@gmail.com",0))
//        }
//    }
//}