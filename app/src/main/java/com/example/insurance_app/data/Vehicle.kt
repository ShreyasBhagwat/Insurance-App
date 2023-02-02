package com.example.insurance_app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Vehicle(
    @PrimaryKey val vehicleId:String,
    @ColumnInfo(name = "VehicleMake") val vehicleMake:String,
    @ColumnInfo(name = "VehicleModel") val vehicleModel:String,
    @ColumnInfo(name = "VehicleRegistrationNumber") val vehicleRegNo:String,
    @ColumnInfo(name = "VehicleType") val vehicleType:String,
    @ColumnInfo(name = "Engine/Chassis No") val ChassisNo:String,
    @ColumnInfo(name = "YearOfManufacture") val vehicleYearOfManufacture:String,
    @ColumnInfo(name = "FuelType") val FuelType:String
    //name ,status ,price,
) {
}