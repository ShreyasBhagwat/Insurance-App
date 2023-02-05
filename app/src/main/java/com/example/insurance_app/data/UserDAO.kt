package com.example.insurance_app.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users:User)

    @Delete
    suspend fun delete(user:User)

    @Update
    suspend fun update(user:User)

    @Query("SELECT * FROM user")
    fun getAll():LiveData<List<User>>
}