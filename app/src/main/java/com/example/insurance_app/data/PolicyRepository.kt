package com.example.insurance_app.data

import android.app.Application
import androidx.lifecycle.LiveData

class PolicyRepository(application: Application) {
    private val mPolicyDAO:PolicyDAO
    private val mGetAll: LiveData<List<Policy>>

    init {
        val database = InsuranceDatabase.getDatabase(application)
        mPolicyDAO = database.policyDao()
        mGetAll = mPolicyDAO.getAll()//LiveData<List<Policy>>
    }

    suspend fun insert(policy: Policy)// = viewModelScope.launch
    {
        mPolicyDAO.insert(policy)
    }

    suspend fun update(policy: Policy) //= viewModelScope.launch
    {
        mPolicyDAO.update(policy)
    }

    suspend fun delete(policy: Policy) //= viewModelScope.launch
    {
        mPolicyDAO.delete(policy)
    }




}