package com.example.insurance_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.insurance_app.data.entity.Mobile
import com.example.insurance_app.data.entity.Vehicle


@Dao
public interface MobileDAO {
    @Insert
    fun insert(mobile: Mobile)

    @Delete
    fun delete(mobile: Mobile)

    @Update
    fun update(mobile: Mobile)

    @Query("SELECT * FROM Mobile order by mobileId")
    fun getAll(): LiveData<List<Mobile>>
}