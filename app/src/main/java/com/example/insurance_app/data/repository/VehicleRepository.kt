package com.example.insurance_app.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.insurance_app.data.entity.Vehicle
import com.example.insurance_app.data.dao.VehicleDAO
import com.example.insurance_app.data.InsuranceDatabase
import com.example.insurance_app.subscribeOnBackground

class VehicleRepository(application: Application) {
    private val mVehicleDAO: VehicleDAO
    private val mGetAll: LiveData<List<Vehicle>>

    init {
        val database = InsuranceDatabase.getInstance(application)
        mVehicleDAO = database.vehicleDao()
        mGetAll = mVehicleDAO.getAll()//LiveData<List<Policy>>
    }

     fun insert(vehicle: Vehicle)// = viewModelScope.launch
    {
        subscribeOnBackground {
            mVehicleDAO.insert(vehicle)
        }

    }

     fun update(vehicle: Vehicle) //= viewModelScope.launch
    {
        subscribeOnBackground {
            mVehicleDAO.update(vehicle)
        }

    }

     fun delete(vehicle: Vehicle) //= viewModelScope.launch
    {
        subscribeOnBackground {
            mVehicleDAO.delete(vehicle)
        }

    }

    fun getAllVehicles():LiveData<List<Vehicle>>{
        return mGetAll
    }

}