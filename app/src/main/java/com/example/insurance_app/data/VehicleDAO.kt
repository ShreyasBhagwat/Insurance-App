package com.example.insurance_app.data

import androidx.room.*

@Dao
public interface VehicleDAO {
    @Insert
    fun insertAll(vararg vehicles:Vehicle)

    @Delete
    fun delete(vehicle:Vehicle)

    @Update
    fun update(vehicle:Vehicle)

    @Query("SELECT * FROM vehicle order by VehicleMake")
    fun getAll():List<Vehicle>
}