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
    private lateinit var seeMore:Button
    lateinit var recyclerView: RecyclerView

    private lateinit var data:LiveData<List<Policy>>
    var PolicyList1:List<Policy> = mutableListOf<Policy>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_policy_list)
        
        recyclerView=findViewById(R.id.PolicyListRecyclerView)
        
        recyclerView.layoutManager=LinearLayoutManager(this)

/*
UserDA= UserDashboardActivity()
vm =
UserDA.vm
dataList= UserDA.passInstance()
viewModel.usersList
*/

        data = ViewModelProvider(this)[InsuranceViewModel::class.java].getAllPolicies()

        
//        PolicyList1=PolicyListData().list
        data.observe(this, Observer {
            PolicyList1= it
            Log.d("Data3",PolicyList1.toString())
            val adapter=ViewAdapter(PolicyList1)
            recyclerView.adapter=adapter

//            adapter.submitList(PolicyList1)
        })

        Log.d("User Datalist-1",PolicyList1.toString())
//        val adapter=ViewAdapter(PolicyList1)
//        recyclerView.adapter=adapter

/*
vm = ViewModelProvider(this)[InsuranceViewModel::class.java]
val data: LiveData<List<Policy>> = vm.getAllPolicies()
Log.d("PolicyList ",vm.getAllPolicies().toString())
Log.d("PolicyList ",data.toString())
val data: LiveData<List<Policy>> = vm.getAllPolicies().observe(this, Observer{
Log.i("Policies observed","$it")
})


*/



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