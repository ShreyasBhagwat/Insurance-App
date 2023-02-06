package com.example.insurance_app.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Policy")
data class Policy(
    @PrimaryKey(autoGenerate = true) val policyID:Int=0,
    @ColumnInfo(name = "PolicyProvider") val policyProvider:String,
    @ColumnInfo(name = "PolicyType") val policyType: String,
//    @ColumnInfo(name = "DateOfClaim") val dateOfClaim:Date,
    @ColumnInfo(name = "Validity") val policyValidity:Int,
    @ColumnInfo(name = "Price") val price:Double,
    @ColumnInfo(name = "Category") val Category:String

//    @ColumnInfo(name = "Status") val status:String
)