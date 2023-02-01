package com.example.insurance_app.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Policy(
    @PrimaryKey val policyID:String,
    @ColumnInfo(name = "PolicyName") val userName:String,
    @ColumnInfo(name = "PolicyAdmin") val policyAdmin:String,
    @ColumnInfo(name = "YearOfPub") val yearOfPub:Date,
    @ColumnInfo(name = "Price") val price:Double,
    @ColumnInfo(name = "Status") val status:String
){

}