package com.example.insurance_app.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.insurance_app.subscribeOnBackground
import java.util.*
//import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.insurance_app.worker.databaseWorker

import com.example.insurance_app.utilities.DATABASE_NAME
import com.example.insurance_app.utilities.USER_DATA_FILENAME
//import com.google.samples.apps.sunflower.workers.databaseWorker

import com.example.insurance_app.worker.databaseWorker.Companion.KEY_FILENAME
import kotlin.coroutines.coroutineContext

@Database(entities = [User::class,Policy::class,Vehicle::class],version =1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class InsuranceDatabase:RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun policyDao(): PolicyDAO
    abstract fun vehicleDao(): VehicleDAO

    companion object{
        private var dbInstance: InsuranceDatabase?=null
        private var context: Context?=null


       //@Synchronized
        fun getInstance(context: Context): InsuranceDatabase {
            return dbInstance ?: synchronized(this) {
                dbInstance ?: buildDatabase(context).also { dbInstance = it }
            }
        }
       /* @Synchronized
       fun getInstance(context: Context):InsuranceDatabase{
           buildDatabase(context.applicationContext)
            if(dbInstance == null)
                dbInstance=Room.databaseBuilder(context.applicationContext,InsuranceDatabase::class.java, "word_database"
                ).fallbackToDestructiveMigration().addCallback(roomCallback).build()

         //  buildDatabase(context.applicationContext)

            return dbInstance!!
        }*/



        private fun buildDatabase(context: Context): InsuranceDatabase {
            return Room.databaseBuilder(context, InsuranceDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<databaseWorker>()
                                .setInputData(workDataOf(KEY_FILENAME to USER_DATA_FILENAME))
                                .build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                )
                .build()
        }

        private val roomCallback=object :Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
//                populateDatabase(dbInstance!!)
                //buildDatabase(context!!)
            }
        }

        private fun populateDatabase(db:InsuranceDatabase){
           // buildDatabase(context!!)
            val userDao = db.userDao()
            val policyDAO=db.policyDao()
            val vehicleDAO=db.vehicleDao()


//            subscribeOnBackground{
//                userDao.insert(User(101,"Shreyas","Bhopal","7987685319","bhagwatshreyas01@gmail.com",true))
//                userDao.insert(User(102,"Dhruv","Surat","9726278998","bhagwatshreyas01@gmail.com",false))
//                policyDAO.insert(Policy(201,"Standard",Calendar.getInstance().toString(),12,15000.0,"Expired" ))
//                policyDAO.insert(Policy(202,"Comprehensive","31/1/2023",12,15000.0,"Active" ))
//                vehicleDAO.insert(Vehicle(301,"HEROHONDA","Splendor","MP04ND7474",2,"06390","04799","2000","Petrol"))
//                vehicleDAO.insert(Vehicle(302,"MARUTI","Alto","MP04CA2729",4,"MA3EYD81S00669097","F8DN3260096","2006","Petrol"))
//            }
        }
    }
}



