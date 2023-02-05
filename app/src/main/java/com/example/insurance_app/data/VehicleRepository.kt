package com.example.insurance_app.data

import android.app.Application
import androidx.lifecycle.LiveData

class VehicleRepository(application: Application) {
    private val mVehicleDAO:VehicleDAO
    private val mGetAll: LiveData<List<Vehicle>>

    init {
        val database = InsuranceDatabase.getDatabase(application)
        mVehicleDAO = database.vehicleDao()
        mGetAll = mVehicleDAO.getAll()//LiveData<List<Policy>>
    }

    suspend fun insert(vehicle: Vehicle)// = viewModelScope.launch
    {
        mVehicleDAO.insert(vehicle)
    }

    suspend fun update(vehicle: Vehicle) //= viewModelScope.launch
    {
        mVehicleDAO.update(vehicle)
    }

    suspend fun delete(vehicle: Vehicle) //= viewModelScope.launch
    {
        mVehicleDAO.delete(vehicle)
    }

}