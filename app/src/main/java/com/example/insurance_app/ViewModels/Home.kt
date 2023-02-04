package com.example.insurance_app.ViewModels

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.insurance_app.EnterUserDetails
import com.example.insurance_app.R
import com.google.android.material.bottomsheet.BottomSheetDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var sharedPreferences:SharedPreferences
    lateinit var sharedPreferencesEditor:Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view=inflater.inflate(R.layout.fragment_home, container, false )

        val carbtn:Button=view.findViewById(R.id.btnVehicle)
        carbtn.setOnClickListener{
            val btn:String="Car"
           openRegistrationNumberBottomScreen(btn)
        }
//        val bikebtn:CardView=view.findViewById(R.id.btnVehicle)
//        carbtn.setOnClickListener{
//            val btn:String="Bike"
//            openRegistrationNumberBottomScreen(btn)
//        }
//        val mobilebtn:CardView=view.findViewById(R.id.btnVehicle)
//        carbtn.setOnClickListener{
//            val btn:String="Mobile"
//            openRegistrationNumberBottomScreen(btn)
//        }
        return view
    }

    private fun openRegistrationNumberBottomScreen(btn:String) {
        val dialog = BottomSheetDialog(context!!)

        val view = layoutInflater.inflate(R.layout.registration_number_bottom_sheet_dialog, null)
        val registrationNumber:EditText=view.findViewById(R.id.vehicleRegistrationNumber)

        val title:TextView=view.findViewById(R.id.titleForBottomSheet)
        if(btn=="Car"){
            title.text="Get up to 40% off on car insurance"
        }
        if(btn=="Bike"){
            title.text="Bike insurance starting at ₹555"
        }
        if(btn=="Mobile"){
            title.text="Save mobile at just ₹200"
            registrationNumber.setText("Enter previous insurance ID")
        }
        val goToEnterUserPolicyDetailsBtn = view.findViewById<ImageButton>(R.id.goToEnterUserPolicyDetails)
        val newInsuranceBtn=view.findViewById<Button>(R.id.newInsuranceBtn)
        goToEnterUserPolicyDetailsBtn.setOnClickListener {
            if(TextUtils.isEmpty(registrationNumber.text.toString())){
                Toast.makeText(context, "Enter Vehicle Number", Toast.LENGTH_SHORT).show()
            }
            else {
                sharedPreferences = this.activity!!.getSharedPreferences(
                    "numberPlate",
                    AppCompatActivity.MODE_PRIVATE
                )
                sharedPreferencesEditor = sharedPreferences.edit()
                sharedPreferencesEditor.putString("number", registrationNumber.text.toString())
                sharedPreferencesEditor.apply()
                val intent:Intent=Intent(context, EnterUserDetails::class.java)
                intent.putExtra("Vehicle",btn)
                startActivity(intent)
            }
        }
        newInsuranceBtn.setOnClickListener{
            val intent:Intent=Intent(context, EnterUserDetails::class.java)
            intent.putExtra("Vehicle",btn)
            startActivity(intent)
        }
        dialog.setCancelable(true)
        dialog.setContentView(view)
        dialog.show()

    }

}