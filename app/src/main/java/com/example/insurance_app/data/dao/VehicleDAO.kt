package com.example.insurance_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.insurance_app.data.entity.Vehicle

@Dao
interface VehicleDAO {
//    @Insert
//    fun insertAll(vararg vehicles: Vehicle)

    @Insert
    fun insert(vehicle: Vehicle)

    @Delete
    fun delete(vehicle: Vehicle)

    @Update
    fun update(vehicle: Vehicle)

    @Query("SELECT * FROM Vehicle order by vehicleId")
    fun getAll(): LiveData<List<Vehicle>>
}