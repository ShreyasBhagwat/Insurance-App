package com.example.insurance_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insurance_app.ViewModels.ViewAdapter
import com.example.insurance_app.data.PolicyListData
import com.example.insurance_app.data.entity.Policy
import com.example.insurance_app.data.viewmodel.InsuranceViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog

class PolicyList : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    private lateinit var data:LiveData<List<Policy>>
    var PolicyList1:List<Policy> = mutableListOf<Policy>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy_list)
        
        recyclerView=findViewById(R.id.PolicyListRecyclerView)
        
        recyclerView.layoutManager=LinearLayoutManager(this)

        data = ViewModelProvider(this)[InsuranceViewModel::class.java].getAllPolicies()

        data.observe(this, Observer {
            PolicyList1= it
            Log.d("Data3",PolicyList1.toString())
            val adapter=ViewAdapter(PolicyList1)
            recyclerView.adapter=adapter
        })

        Log.d("User Datalist-1",PolicyList1.toString())

    }
}