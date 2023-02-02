package com.example.insurance_app.data

import androidx.room.*

@Dao
public interface AdminDAO {
    @Insert
    fun insertAll(vararg admins:Admin)

    @Delete
    fun delete(admin:Admin)

    @Update
    fun update(admin:Admin)

    @Query("SELECT * FROM admin order by AdminName")
    fun getAll():List<Admin>
}

