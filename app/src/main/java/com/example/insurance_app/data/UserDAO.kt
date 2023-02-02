package com.example.insurance_app.data

import androidx.room.*

@Dao
public interface UserDAO {
    @Insert
    fun insertAll(vararg users:User)

    @Delete
    fun delete(user:User)

    @Update
    fun update(user:User)

    @Query("SELECT * FROM user order by UserName")
    fun getAll():List<User>
}