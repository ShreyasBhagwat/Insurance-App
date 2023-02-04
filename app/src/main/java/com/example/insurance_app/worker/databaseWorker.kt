package com.example.insurance_app.worker

import android.content.Context
//import android.util.JsonReader
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.insurance_app.data.InsuranceDatabase
import com.example.insurance_app.data.User
//import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.reflect.Type

class databaseWorker( context: Context,workerParams: WorkerParameters):CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val filename = inputData.getString(KEY_FILENAME)
            if (filename != null) {
                applicationContext.assets.open(filename).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val userType = object : TypeToken<List<User>>() {}.type
                        val userList: List<User> = Gson().fromJson(jsonReader, userType)

                        val database = InsuranceDatabase.getInstance(applicationContext)
                        database.userDao().insertAll(userList)

                        Result.success()
                    }
                }
            } else {
                Log.e(TAG, "Error seeding database - no valid filename")
                Result.failure()
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "databaseWorker"
        const val KEY_FILENAME = "USER_DATA_FILENAME"
    }
}




//class SeedDatabaseWorker(
//    context: Context,
//    workerParams: WorkerParameters
//) : CoroutineWorker(context, workerParams) {
//    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
//        try {
//            val filename = inputData.getString(KEY_FILENAME)
//            if (filename != null) {
//                applicationContext.assets.open(filename).use { inputStream ->
//                    JsonReader(inputStream.reader()).use { jsonReader ->
//                        val plantType = object : TypeToken<List<Plant>>() {}.type
//                        val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)
//
//                        val database = AppDatabase.getInstance(applicationContext)
//                        database.plantDao().insertAll(plantList)
//
//                        Result.success()
//                    }
//                }
//            } else {
//                Log.e(TAG, "Error seeding database - no valid filename")
//                Result.failure()
//            }
//        } catch (ex: Exception) {
//            Log.e(TAG, "Error seeding database", ex)
//            Result.failure()
//        }
//    }
//
//    companion object {
//        private const val TAG = "SeedDatabaseWorker"
//        const val KEY_FILENAME = "PLANT_DATA_FILENAME"
//    }
//}
