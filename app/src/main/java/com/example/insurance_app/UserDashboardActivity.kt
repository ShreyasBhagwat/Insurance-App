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
//    private lateinit var viewAdapter: RecyclerView.Adapter<*>
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this)[InsuranceViewModel::class.java]

        data= vm.getAllPolicies()
//        Log.d("Data",data.toString())
        data.observe(this, Observer {
            PolicyList1= it
//            policyListData.list=it
            Log.d("Data2",PolicyList1.toString())
//            Log.d("Listform setter",policyListData.toString())
        })
        Log.d("Bahar se Data2",PolicyList1.toString())


/*//            adapter.submitList(it)

//        data.observe(this,  Observer{
////            viewAdapter.notifyDataSetChanged()
//            PolicyList1= it
//            Log.d("Data2",PolicyList1.toString())


//            val view = layoutInflater.inflate(R.layout.activity_policy_list, null)


recyclerView=view.findViewById<RecyclerView?>(R.id.PolicyListRecyclerView).apply {
layoutManager=viewManager
adapter=viewAdapter
}
PolicyList1 = emptyList<Policy>()//listOf(Policy())//List<Policy>
data.observe(this, Observer {
//            viewAdapter.notifyDataSetChanged()
PolicyList1= it
Log.d("Data2",PolicyList1.toString())

})
vm.getAllPolicies().observe(this, Observer {
Log.i("Policies observed","$it")

//            ViewAdapter.submitList(it)
})
*/

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