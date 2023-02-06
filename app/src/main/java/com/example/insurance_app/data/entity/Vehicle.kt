package com.example.insurance_app.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Vehicle")
data class Vehicle(
    @PrimaryKey val vehicleId:Int,
    @ColumnInfo(name = "VehicleMake") val vehicleMake:String,
    @ColumnInfo(name = "VehicleModel") val vehicleModel:String,
    @ColumnInfo(name = "VehicleRegistrationNumber") val vehicleRegNo:String,
    @ColumnInfo(name = "VehicleType") val vehicleType:Int,
    @ColumnInfo(name = "Chassis No") val ChassisNo:String,
    @ColumnInfo(name = "Engine No") val EngineNo:String,
    @ColumnInfo(name = "YearOfManufacture") val vehicleYearOfManufacture:String,
    @ColumnInfo(name = "FuelType") val FuelType:String
    //name ,status ,price,
)