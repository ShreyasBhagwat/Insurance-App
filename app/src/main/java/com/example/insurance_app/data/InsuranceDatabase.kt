package com.example.insurance_app.data

//import androidx.sqlite.db.SupportSQLiteDatabase

//import com.google.samples.apps.sunflower.workers.databaseWorker

import android.content.Context
import androidx.room.*
import java.util.*

@Database(entities = [User::class,Policy::class,Vehicle::class],version =1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class InsuranceDatabase:RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun policyDao(): PolicyDAO
    abstract fun vehicleDao(): VehicleDAO

    companion object{

        @Volatile
        private var dbInstance: InsuranceDatabase?=null


        fun getDatabase(context: Context):InsuranceDatabase{
            if(dbInstance ==null){
                synchronized(this){
                    dbInstance = buildDatabase(context)
                }
            }
            return dbInstance!!
        }

        private fun buildDatabase(context: Context):InsuranceDatabase{
            return Room.databaseBuilder(
                context.applicationContext,
                InsuranceDatabase::class.java,
                "Insurance_DB"
            )
                .build()
        }
    }
}
/*

@Synchronized
fun getInstance(context: Context):InsuranceDatabase{
buildDatabase(context.applicationContext)
if(dbInstance == null)
dbInstance=Room.databaseBuilder(context.applicationContext,InsuranceDatabase::class.java, "_database"
).addCallback(PrefillingUser(context)).build()

//  buildDatabase(context.applicationContext)

return dbInstance as InsuranceDatabase
}



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


subscribeOnBackground{
userDao.insert(User(101,"Shreyas","Bhopal","7987685319","bhagwatshreyas01@gmail.com",true))
userDao.insert(User(102,"Dhruv","Surat","9726278998","bhagwatshreyas01@gmail.com",false))
policyDAO.insert(Policy(201,"Standard",Calendar.getInstance().toString(),12,15000.0,"Expired" ))
policyDAO.insert(Policy(202,"Comprehensive","31/1/2023",12,15000.0,"Active" ))
vehicleDAO.insert(Vehicle(301,"HEROHONDA","Splendor","MP04ND7474",2,"06390","04799","2000","Petrol"))
vehicleDAO.insert(Vehicle(302,"MARUTI","Alto","MP04CA2729",4,"MA3EYD81S00669097","F8DN3260096","2006","Petrol"))
}
}
}
}
*/



