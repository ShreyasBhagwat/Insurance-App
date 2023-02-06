package com.example.insurance_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.insurance_app.data.entity.Policy

@Dao
interface PolicyDAO {
    @Insert
     fun insertAll(vararg policies: Policy)

    @Insert
     fun insert(policy: Policy)

    @Delete
     fun delete(policy: Policy)



    @Query("SELECT * FROM Policy order by PolicyProvider")
    fun getAll():LiveData<List<Policy>>

    @Query("SELECT * FROM Policy WHERE CATEGORY = :policyCategory")
    fun getByCategory(policyCategory: String):LiveData<List<Policy>>

    @Update
     fun update(policy: Policy)


}