package com.example.insurance_app.ViewModels


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.insurance_app.R
import com.example.insurance_app.data.entity.Policy
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.NO_POSITION



class ViewAdapter(var data:List<Policy>): RecyclerView.Adapter<ViewAdapter.ViewHolder>() {

//     var data2:List<Policy> = ArrayList<Policy>()
//    private lateinit var vm: InsuranceViewModel

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
//            Log.d("ViewAdapter",data)
        }
    }
//    fun submitList(policyList: List<Policy>?) {
//        Log.d("Data from adapter",policyList.toString())
//        if (policyList != null) {
//            data2 =policyList
//        }
//        notifyDataSetChanged()
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(parent.context)
           .inflate(R.layout.cardview_recycleview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Data inside viewholder",data.toString())
        val dataList = data[position]
        Log.d("DataList",dataList.toString())
//        val policyVM : LiveData<List<Policy>> = data //?:Policy(31,"Bajaj","Third Party",12,50000.0,"Car")
        holder.policyName.text=dataList.policyProvider
        holder.policyValidity.text=dataList.policyValidity.toString()
        holder.policyType.text=dataList.policyType
        holder.policyPrice.text=dataList.price.toString()

//        with(getItemId(position)){
//            holder.policyName.text = data2[position].policyProvider
//            holder.policyType.text = data2[position].policyType
//            holder.policyValidity.text = data2[position].policyValidity.toString()
//            holder.policyPrice.text = data2[position].price.toString()
//        }
//        val viewItem=data[position]
//        holder.policyName.text= policyProvider
    }
    override fun getItemCount() = data.size


/*
val policyVM : LiveData<List<Policy>> = data //?:Policy(31,"Bajaj","Third Party",12,50000.0,"Car")
holder.policyName.text=policyVM.value.
holder.policyValidity.text=policyVM.policyValidity.toString()
holder.policyType.text=policyVM.policyType
holder.policyPrice.text=policyVM.price.toString()
with(data.value?.get(position)){
holder.policyName.text= this?.policyProvider
holder.policyValidity.text=this?.policyValidity.toString()
holder.policyType.text=this?.policyType
holder.policyPrice.text=this?.price.toString()
}
//
val policyVM : List<Policy> = dataSet.value?.get(position) ?:Policy(31,"Bajaj","Third Party",12,50000.0,"Car")
holder.policyName.text=policyVM.policyProvider
holder.policyValidity.text=policyVM.policyValidity.toString()
holder.policyType.text=policyVM.policyType
holder.policyPrice.text=policyVM.price.toString()
//    }
*/




}