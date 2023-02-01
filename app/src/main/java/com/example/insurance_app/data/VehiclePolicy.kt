package com.example.insurance_app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
abstract class VehiclePolicy(
    @PrimaryKey val vehiclePolicyId:String,
    @ColumnInfo(name = "Name") val userName:String,

    //name ,status ,price,
) {
}