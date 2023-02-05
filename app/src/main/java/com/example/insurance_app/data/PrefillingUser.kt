package com.example.insurance_app.data
//
//import android.content.Context
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import com.example.insurance_app.R
//import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import org.json.JSONArray
//import org.json.JSONException
//import java.io.BufferedReader
//import java.util.*
//
//class PrefillingUser(private val context: Context):RoomDatabase.Callback() {
//    override fun onCreate(db: SupportSQLiteDatabase) {
//        super.onCreate(db)
//
//        CoroutineScope(Dispatchers.IO).launch {
//            fillWithStartingUserData(context)
//        }
//    }
//
//    private suspend fun fillWithStartingUserData(context: Context) {
//        val dao = InsuranceDatabase.getDatabase(context).userDao()
//
//        try {
//            val user = loadJsonArray(context)
//            if(user!=null){
//                //looping through the variable as specified fields are loaded with data
//                for (i in 0 until user.length()){
//                    //variable to obtain the JSON object
//                    val item = user.getJSONObject(i)
//                    //Using the JSON object to assign data
//                    val userId = item.getInt("userID")
//                    val userName = item.getString("UserName")
//                    val userAddress = item.getString("UserAddress")
//                    val userMobileNo = item.getString("UserMobileNo")
//                    val userEmail = item.getString("UserEmail")
//                    val isAdmin = item.getInt("isAdmin")
//
//                    val userEntity = User(userId,userName,userAddress,userMobileNo,userEmail,isAdmin)
//
//                    dao.insert(userEntity)
//                }
//
//            }
//        }
//        catch (e:JSONException){
//            android.util.Log.d("fillWithStartingUserData", e.toString())
//        }
//
//    }
//
//
//    private fun loadJsonArray(context: Context): JSONArray {
//            val inputStream = context.resources.openRawResource(R.raw.entries1)
//            BufferedReader(inputStream.reader()).use {
//                return JSONArray(it.readText())
//            }
//        }
//
//}