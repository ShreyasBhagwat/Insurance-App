package com.example.insurance_app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Policy(
    @PrimaryKey val policyID:Int,
    @ColumnInfo(name = "PolicyName") val policyName:String,
//    @ColumnInfo(name = "PolicyAdmin") val policyAdmin: String,
    @ColumnInfo(name = "DateOfClaim") val dateOfClaim:Date,
    @ColumnInfo(name = "Validity") val policyValidity:Int,
    @ColumnInfo(name = "Price") val price:Double,
    @ColumnInfo(name = "Status") val status:String
)