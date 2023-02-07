package com.example.insurance_app.data.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.insurance_app.data.entity.Mobile
import com.example.insurance_app.data.entity.Policy
import com.example.insurance_app.data.entity.User
import com.example.insurance_app.data.entity.Vehicle
import com.example.insurance_app.data.repository.MobileRepository
import com.example.insurance_app.data.repository.PolicyRepository
import com.example.insurance_app.data.repository.UserRepository
import com.example.insurance_app.data.repository.VehicleRepository

data class InsuranceViewModel(val app:Application):AndroidViewModel(app) {

    private val pRepository = PolicyRepository(app)
    private val vRepository = VehicleRepository(app)
    private val uRepository = UserRepository(app)
    private val mRepository = MobileRepository(app)



//    private val allPolicies = pRepository.getAllPolicies()
    private val allVehicles = vRepository.getAllVehicles()
    private val allUsers = uRepository.getAllUsers()
    private val allMobile = mRepository.getAllMobiles()

    private val policyCategory = pRepository.getByCategory("")


    //Inserts
    fun insert(policy:Policy){
        pRepository.insert(policy)
    }
    fun insert(vehicle: Vehicle){
        vRepository.insert(vehicle)
    }
    fun insert(user: User){
        uRepository.insert(user)
    }
    fun insert(mobile: Mobile){
        mRepository.insert(mobile)
    }

    //Updates
    fun update(policy:Policy){
        pRepository.update(policy)
    }
    fun update(vehicle: Vehicle){
        vRepository.update(vehicle)
    }
    fun update(user: User){
        uRepository.update(user)
    }
    fun update(mobile: Mobile){
        mRepository.update(mobile)
    }

    //Deletes
    fun delete(policy:Policy){
        pRepository.delete(policy)
    }
    fun delete(vehicle: Vehicle){
        vRepository.delete(vehicle)
    }
    fun delete(user: User) {
        uRepository.delete(user)
    }
    fun delete(mobile: Mobile){
        mRepository.delete(mobile)
    }

    //Get all functions
    fun getAllPolicies():LiveData<List<Policy>>{

        return pRepository.getAllPolicies()


    }
    fun allVehicles():LiveData<List<Vehicle>>{
        return allVehicles
    }
    fun allUsers():LiveData<List<User>>{
        return allUsers
    }
    fun allMobiles():LiveData<List<Mobile>>{
        return allMobile
    }

    //Custom Functions
    fun getByCategory():LiveData<List<Policy>>{
        return policyCategory
    }

}