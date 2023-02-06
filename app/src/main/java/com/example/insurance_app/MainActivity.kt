package com.example.insurance_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.insurance_app.data.viewmodel.InsuranceViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var vm:InsuranceViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[InsuranceViewModel::class.java]

        vm.getAllPolicies().observe(this, Observer {
            Log.i("Policies observed","$it")

            //adapter.submitList(it)
        })
    }
}