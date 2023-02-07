package com.example.insurance_app.data

import androidx.room.TypeConverter
import java.util.*

//class Converters {
//}
class Converters {
    @TypeConverter
    fun dateToLong(value: Date): Long = value.time

    @TypeConverter
    fun longToDate(value: Long): Date = Date(value)
}