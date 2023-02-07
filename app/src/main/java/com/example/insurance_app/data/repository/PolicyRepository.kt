package com.example.insurance_app.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.insurance_app.data.entity.Policy
import com.example.insurance_app.data.dao.PolicyDAO
import com.example.insurance_app.data.InsuranceDatabase
import com.example.insurance_app.subscribeOnBackground

class PolicyRepository(application: Application) {
    private val mPolicyDAO: PolicyDAO
    private val mGetAll: LiveData<List<Policy>>
    private val mGetCategory: LiveData<List<Policy>>
    private val category:String = ""


    init {
        val database = InsuranceDatabase.getInstance(application)
        mPolicyDAO = database.policyDao()
        mGetAll = mPolicyDAO.getAll()//LiveData<List<Policy>>
        mGetCategory = mPolicyDAO.getByCategory(category)

    }

     fun insert(policy: Policy)// = viewModelScope.launch
    {
        subscribeOnBackground {
            mPolicyDAO.insert(policy)
        }

    }

     fun update(policy: Policy) //= viewModelScope.launch
    {
        subscribeOnBackground {
            mPolicyDAO.update(policy)
        }

    }

     fun delete(policy: Policy) //= viewModelScope.launch
    {
        subscribeOnBackground {
            mPolicyDAO.delete(policy)
        }

    }

    fun getAllPolicies():LiveData<List<Policy>>{

        return mGetAll
    }

    fun getByCategory(category:String):LiveData<List<Policy>>{
        return mGetCategory
    }






}