package com.example.insurance_app.ViewModels


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insurance_app.R
import com.example.insurance_app.data.entity.Policy




class ViewAdapter(var data:List<Policy>): RecyclerView.Adapter<ViewAdapter.ViewHolder>() {

    class ViewHolder (view:View):RecyclerView.ViewHolder(view){


        val policyName:TextView
        val policyPrice:TextView
        val policyType:TextView
        val policyValidity:TextView

        init {
            policyName=view.findViewById(R.id.policyName)
            policyPrice=view.findViewById(R.id.policyPrice)
            policyType=view.findViewById(R.id.policyType)
            policyValidity=view.findViewById(R.id.policyValidity)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(parent.context)
           .inflate(R.layout.cardview_recycleview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Data inside viewholder",data.toString())
        val dataList = data[position]
        Log.d("DataList",dataList.toString())
        holder.policyName.text=dataList.policyProvider
        holder.policyValidity.text=dataList.policyValidity.toString()
        holder.policyType.text=dataList.policyType
        holder.policyPrice.text=dataList.price.toString()

    }
    override fun getItemCount() = data.size







}