package com.example.insurance_app.ViewModels


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.insurance_app.BuyPolicyActivity
import com.example.insurance_app.PolicyList
import com.example.insurance_app.R
import com.example.insurance_app.data.entity.Policy
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.math.roundToInt


class ViewAdapter(var data:List<Policy>): RecyclerView.Adapter<ViewAdapter.ViewHolder>() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferencesEditor: SharedPreferences.Editor
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
        holder.policyValidity.text=dataList.policyValidity.toString()+" Months"
        holder.policyType.text=dataList.policyType
        holder.policyPrice.text="₹"+dataList.price.roundToInt().toString()
        holder.itemView.findViewById<Button>(R.id.priceButton).setOnClickListener {
            val context = it.context
            var intent = Intent(it.context, BuyPolicyActivity::class.java)
            intent.putExtra("ActualPrice",holder.policyPrice.text)
            intent.putExtra("PolicyPosition",position)
            sharedPreferences=context.getSharedPreferences("PolicyBuy",
                AppCompatActivity.MODE_PRIVATE
            )
            sharedPreferencesEditor=sharedPreferences.edit()

            it.context.startActivity(intent)
        }

    }
    override fun getItemCount() = data.size







}