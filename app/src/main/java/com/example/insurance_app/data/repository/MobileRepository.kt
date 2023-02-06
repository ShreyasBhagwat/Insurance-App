package com.example.insurance_app.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.insurance_app.data.InsuranceDatabase
import com.example.insurance_app.data.dao.MobileDAO
import com.example.insurance_app.data.entity.Mobile
import com.example.insurance_app.data.entity.Vehicle
import com.example.insurance_app.subscribeOnBackground

class MobileRepository(application: Application) {
    private val mMobileDAO:MobileDAO
    private val mGetAll: LiveData<List<Mobile>>

    init {
        val database=InsuranceDatabase.getInstance(application)
        mMobileDAO = database.mobileDao()
        mGetAll =mMobileDAO.getAll()
    }

    fun insert(mobile: Mobile)// = viewModelScope.launch
    {
        subscribeOnBackground {
            mMobileDAO.insert(mobile)
        }

    }

    fun update(mobile: Mobile) //= viewModelScope.launch
    {
        subscribeOnBackground {
            mMobileDAO.update(mobile)
        }

    }

    fun delete(mobile: Mobile) //= viewModelScope.launch
    {
        subscribeOnBackground {
            mMobileDAO.delete(mobile)
        }

    }

    fun getAllMobiles():LiveData<List<Mobile>>{
        return mGetAll
    }

}