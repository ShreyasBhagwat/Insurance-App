package com.example.insurance_app.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PolicyDAO {
    @Insert
    suspend fun insertAll(vararg policies:Policy)

    @Insert
    suspend fun insert(policy: Policy)

    @Delete
    suspend fun delete(policy:Policy)

    @Query("SELECT * FROM policy order by PolicyName")
    fun getAll():LiveData<List<Policy>>

    @Update
    suspend fun update(policy:Policy)


}