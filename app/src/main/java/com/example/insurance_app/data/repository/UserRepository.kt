package com.example.insurance_app.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.insurance_app.data.entity.User
import com.example.insurance_app.data.dao.UserDAO
import com.example.insurance_app.data.InsuranceDatabase
import com.example.insurance_app.subscribeOnBackground

class UserRepository(application: Application) {
    private val mUserDAO: UserDAO
    private val mGetAll: LiveData<List<User>>

    init {
        val database = InsuranceDatabase.getInstance(application)
        mUserDAO = database.userDao()
        mGetAll = mUserDAO.getAll()//LiveData<List<Policy>>
    }

     fun insert(user: User)// = viewModelScope.launch
    {
        subscribeOnBackground {
            mUserDAO.insert(user)
        }

    }

     fun update(user: User) //= viewModelScope.launch
    {
        subscribeOnBackground {
            mUserDAO.update(user)
        }

    }

     fun delete(user: User) //= viewModelScope.launch
    {
        subscribeOnBackground {
            mUserDAO.delete(user)
        }

    }

    fun getAllUsers():LiveData<List<User>>{
        return mGetAll
    }




}