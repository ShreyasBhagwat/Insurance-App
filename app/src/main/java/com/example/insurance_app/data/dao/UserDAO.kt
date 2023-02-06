package com.example.insurance_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.insurance_app.data.entity.User

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(users: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(users: User)

    @Delete
     fun delete(user: User)

    @Update
     fun update(user: User)

    @Query("SELECT * FROM User")
    fun getAll():LiveData<List<User>>
}