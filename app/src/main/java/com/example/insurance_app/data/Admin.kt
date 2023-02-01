package com.example.insurance_app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Admin(
    @PrimaryKey val adminId:Int,
    @ColumnInfo(name = "AdminName") val adminName:String
)

