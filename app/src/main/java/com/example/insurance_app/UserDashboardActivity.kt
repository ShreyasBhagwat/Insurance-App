package com.example.insurance_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insurance_app.ViewModels.*
import com.example.insurance_app.data.PolicyListData
import com.example.insurance_app.data.entity.Policy
import com.example.insurance_app.data.viewmodel.InsuranceViewModel
import com.example.insurance_app.databinding.ActivityUserDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


open class UserDashboardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUserDashboardBinding
    lateinit var vm: InsuranceViewModel
    private lateinit var data:LiveData<List<Policy>>
    var policyListData=PolicyListData()
    var PolicyList1:List<Policy> = mutableListOf<Policy>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this)[InsuranceViewModel::class.java]

        data= vm.getAllPolicies()

        data.observe(this, Observer {
            PolicyList1= it

            Log.d("Data2",PolicyList1.toString())

        })
        Log.d("Bahar se Data2",PolicyList1.toString())




        binding = ActivityUserDashboardBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_user_dashboard)
        replaceFragment(Home())

        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setOnNavigationItemSelectedListener {

                when(it.itemId){
                    R.id.home -> replaceFragment(Home())
                    R.id.policy -> replaceFragment(PolicyFragment())
                    R.id.help -> replaceFragment(Help())
                    R.id.Profile -> replaceFragment(Profile())

                    else -> {

                    }
                }

                true
            }
    }

    open fun passInstance():List<Policy>{
        return PolicyList1
    }
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}