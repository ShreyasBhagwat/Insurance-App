package com.example.insurance_app.data

import android.app.Application
import androidx.lifecycle.LiveData

public class UserRepository(application: Application) {
    private val mUserDAO:UserDAO
    private val mGetAll: LiveData<List<User>>

    init {
        val database = InsuranceDatabase.getInstance(application)
        mUserDAO = database.userDao()
        mGetAll = mUserDAO.getAll()//LiveData<List<Policy>>
    }

    suspend fun insert(user: User)// = viewModelScope.launch
    {
        mUserDAO.insert(user)
    }

    suspend fun update(user: User) //= viewModelScope.launch
    {
        mUserDAO.update(user)
    }

    suspend fun delete(user: User) //= viewModelScope.launch
    {
        mUserDAO.delete(user)
    }




}