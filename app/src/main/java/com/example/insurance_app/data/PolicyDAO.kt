package com.example.insurance_app.data

import androidx.room.*

@Dao
public interface PolicyDAO {
    @Insert
    fun insertAll(vararg policies:Policy)

    @Delete
    fun delete(policy:Policy)

    @Update
    fun update(policy:Policy)

    @Query("SELECT * FROM policy order by PolicyName")
    fun getAll():List<Policy>
}