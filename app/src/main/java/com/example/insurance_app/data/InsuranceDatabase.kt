package com.example.insurance_app.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class,Admin::class,Policy::class,Vehicle::class],version =1, exportSchema = false)
abstract class InsuranceDatabase:RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun adminDao(): AdminDAO
    abstract fun policyDao(): PolicyDAO
    abstract fun vehicleDao(): VehicleDAO
}
/*
companion object{
//for Singleton instantiation
@Volatile private var instance:InsuranceDatabase?=null

//        @OptIn(InternalCoroutinesApi::class)
//        fun getInstance(context: Context):AppDatabase{
//            return instance?: synchronized(this){
//                instance?:buildDatabase(context).also{ instance=it}
//            }
//        }

//        private fun buildDatabase(context: Context): AppDatabase {
//            return Room.databaseBuilder(context,AppDatabase::class.java,DATABASE_NAME)
//                .addCallback(
//                    object :RoomDatabase.Callback(){
//                        override fun onCreate(db:SupportSQLiteDatabase){
//                            super.onCreate(db)
//                            val request = OneTimeWorkRequestBuilder<>
//                        }
//                    }
//                )
//
//        }
}
*/
