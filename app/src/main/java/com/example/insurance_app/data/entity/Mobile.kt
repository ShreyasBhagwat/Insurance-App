package com.example.insurance_app.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Mobile")
data class Mobile (
    @PrimaryKey(autoGenerate = true) val mobileId:Int,
    @ColumnInfo(name = "MobileMake") val mobileMake:String,
    @ColumnInfo(name = "MobileModel") val mobileModel:String,
    @ColumnInfo(name = "YearOfManufacture") val vehicleYearOfManufacture:String,
)