package com.example.insurance_app.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VehicleDAO {
    @Insert
    suspend fun insertAll(vararg vehicles:Vehicle)

    @Insert
    suspend fun insert(vehicle: Vehicle)

    @Delete
    suspend fun delete(vehicle:Vehicle)

    @Update
    suspend fun update(vehicle:Vehicle)

    @Query("SELECT * FROM vehicle order by VehicleMake")
    fun getAll(): LiveData<List<Vehicle>>
}