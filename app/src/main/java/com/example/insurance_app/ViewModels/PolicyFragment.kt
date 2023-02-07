package com.example.insurance_app.ViewModels

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.insurance_app.EnterDetails
import com.example.insurance_app.R
import com.google.android.material.bottomsheet.BottomSheetDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PolicyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PolicyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mainLinerLayoutForRegistrationNumber: LinearLayout
    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferencesEditor: SharedPreferences.Editor

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
        val view=inflater.inflate(R.layout.fragment_policy, container, false)
        val carbtn: CardView =view.findViewById(R.id.carCardView)
        carbtn.setOnClickListener{
            val btn:String="Car"
            val view = layoutInflater.inflate(R.layout.registration_number_bottom_sheet_dialog, null)
            mainLinerLayoutForRegistrationNumber=view.findViewById(R.id.mainLinerLayoutForResistrationNumber)
            mainLinerLayoutForRegistrationNumber.background=resources.getDrawable(R.drawable.background_car,null)
            openRegistrationNumberBottomScreen(btn,view)
        }
        val bikebtn: CardView =view.findViewById(R.id.bikeCardView)
        bikebtn.setOnClickListener{
            val btn:String="Bike"
            val view = layoutInflater.inflate(R.layout.registration_number_bottom_sheet_dialog, null)
            mainLinerLayoutForRegistrationNumber=view.findViewById(R.id.mainLinerLayoutForResistrationNumber)
            mainLinerLayoutForRegistrationNumber.background=resources.getDrawable(R.drawable.background_bike,null)
            openRegistrationNumberBottomScreen(btn, view)
        }
        val mobilebtn: CardView =view.findViewById(R.id.mobileCardView)
        mobilebtn.setOnClickListener{
            val btn:String="Mobile"
            val view = layoutInflater.inflate(R.layout.registration_number_bottom_sheet_dialog, null)
            mainLinerLayoutForRegistrationNumber=view.findViewById(R.id.mainLinerLayoutForResistrationNumber)
            mainLinerLayoutForRegistrationNumber.background=resources.getDrawable(R.drawable.background_mobile,null)
            openRegistrationNumberBottomScreen(btn, view)
        }
        return view
    }

    private fun openRegistrationNumberBottomScreen(btn: String, view: View) {
        val dialog = BottomSheetDialog(context!!)

        val registrationNumber: EditText =view.findViewById(R.id.vehicleRegistrationNumber)
        mainLinerLayoutForRegistrationNumber=view.findViewById(R.id.mainLinerLayoutForResistrationNumber)
        val title: TextView =view.findViewById(R.id.titleForBottomSheet)
        if(btn=="Car"){
            title.text="Get up to 40% off on car insurance"
        }
        if(btn=="Bike"){
            title.text="Bike insurance starting at ₹555"
        }
        if(btn=="Mobile"){
            title.text="Save mobile at just ₹200"
            registrationNumber.setHint("Enter previous insurance ID")
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
                val intent: Intent = Intent(context, EnterDetails::class.java)
                intent.putExtra("Vehicle",btn)
                startActivity(intent)
            }
        }
        newInsuranceBtn.setOnClickListener{
            val intent: Intent = Intent(context, EnterDetails::class.java)
            intent.putExtra("Vehicle",btn)
            startActivity(intent)
        }
        dialog.setCancelable(true)
        dialog.setContentView(view)
        dialog.show()
    }
}