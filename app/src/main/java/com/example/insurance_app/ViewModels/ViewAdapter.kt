package com.example.insurance_app.ViewModels

import android.media.session.PlaybackState.CustomAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insurance_app.R

class ViewAdapter(private val dataSet:Array<String>):RecyclerView.Adapter<ViewAdapter.ViewHolder>() {
    class ViewHolder (view:View):RecyclerView.ViewHolder(view){
        val policyName:TextView
        val policyPrice:TextView
        val policyStatus:TextView
        val policyPublishYear:TextView
        init {
            policyName=view.findViewById(R.id.policyName)
            policyPrice=view.findViewById(R.id.policyPrice)
            policyStatus=view.findViewById(R.id.policystatus)
            policyPublishYear=view.findViewById(R.id.yearOfPublish)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(parent.context)
           .inflate(R.layout.cardview_recycleview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.policyName.text=dataSet[position]
        holder.policyPublishYear.text=dataSet[position]
        holder.policyStatus.text=dataSet[position]
        holder.policyPrice.text=dataSet[position]

    }

    override fun getItemCount()=dataSet.size
}