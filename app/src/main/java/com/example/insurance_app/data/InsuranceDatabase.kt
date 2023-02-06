package com.example.insurance_app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.insurance_app.data.dao.*
import com.example.insurance_app.data.entity.Mobile
import com.example.insurance_app.data.entity.Policy
import com.example.insurance_app.data.entity.User
import com.example.insurance_app.data.entity.Vehicle
import com.example.insurance_app.subscribeOnBackground

import java.util.*



@Database(entities = [User::class, Policy::class, Vehicle::class, Mobile::class],version =1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class InsuranceDatabase:RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun policyDao(): PolicyDAO
    abstract fun vehicleDao(): VehicleDAO
    abstract fun mobileDao(): MobileDAO

    companion object{
        private var dbInstance:InsuranceDatabase?=null

        @Synchronized
        fun getInstance(context: Context):InsuranceDatabase{
            if(dbInstance ==null)
                dbInstance =Room.databaseBuilder(context.applicationContext,InsuranceDatabase::class.java,"Insurance_DB")
                    .addCallback(roomCallBack).build()

            return dbInstance!!
        }

        private val roomCallBack = object :Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(dbInstance!!)
            }
        }

        private fun populateDatabase(db: InsuranceDatabase) {
            val policyDAO = db.policyDao()
            subscribeOnBackground {
//                policyDAO.insert(Policy(201,"Standard",Calendar.getInstance().toString(),12,15000.0,"Expired" ))
//                policyDAO.insert(Policy(202,"Comprehensive","31/1/2023",12,15000.0,"Active" ))
//                policyDAO.insert(Policy(202,"Comprehensive","31/1/2023",12,15000.0,"Active" ))

                val policyTypes = arrayOf("Comprehensive", "Third Party")
                val policyProvider = arrayOf("Bajaj Allianz", "General Insurance","HDFC ERGO General Insurance",
                "ICICI Lombard General Insurance",
                "Royal Sundaram General Insurance",
                "Bharti AXA General Insurance",
                "Tata AIG General Insurance",
                "Reliance General Insurance",
                "National Insurance",
                "New India Assurance",
                "United India Insurance",
                "IFFCO-Tokio General Insurance",
                "SBI General Insurance",
                "Liberty General Insurance")
                val category = arrayOf("Car", "Bike","Mobile")
                val random = Random()


                for (i in 1..30) {
                    val policyProvider = policyProvider[random.nextInt(policyProvider.size)]
                    val policyType = policyTypes[random.nextInt(policyTypes.size)]
                    val duration = random.nextInt(24) + 1
                    val coverageAmount = (random.nextDouble() * 100000) + 5000
                    val category = category[random.nextInt(category.size)]

                    policyDAO.insert(Policy(i, policyProvider, policyType, duration, coverageAmount, category))
                }
            }
        }
    }
}



//subscribeOnBackground{
//userDao.insert(User(101,"Shreyas","Bhopal","7987685319","bhagwatshreyas01@gmail.com",true))
//userDao.insert(User(102,"Dhruv","Surat","9726278998","bhagwatshreyas01@gmail.com",false))
//policyDAO.insert(Policy(201,"Standard",Calendar.getInstance().toString(),12,15000.0,"Expired" ))
//policyDAO.insert(Policy(202,"Comprehensive","31/1/2023",12,15000.0,"Active" ))
//vehicleDAO.insert(Vehicle(301,"HEROHONDA","Splendor","MP04ND7474",2,"06390","04799","2000","Petrol"))
//vehicleDAO.insert(Vehicle(302,"MARUTI","Alto","MP04CA2729",4,"MA3EYD81S00669097","F8DN3260096","2006","Petrol"))
//}
//}
//}
//}
//*/
//
//
//
