package com.example.insurance_app.data

import android.app.Application
import androidx.lifecycle.LiveData

public class VehicleRepository(application: Application) {
    private val mVehicleDAO:VehicleDAO
    private val mGetAll: LiveData<List<Vehicle>>

    init {
        val database = InsuranceDatabase.getInstance(application)
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