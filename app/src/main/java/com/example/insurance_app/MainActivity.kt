package com.example.insurance_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val singUp:TextView=findViewById(R.id.singUp)
        val logIn:TextView=findViewById(R.id.logIn)
        val singUpLayout:LinearLayout=findViewById(R.id.singUpLayout)
        val logInLayout:LinearLayout=findViewById(R.id.logInLayout)
        val singIn:Button=findViewById(R.id.singIn)
        val email:EditText=findViewById(R.id.eMail)
        val password:EditText=findViewById(R.id.passwords)
        val confirmPassword:EditText=findViewById(R.id.passwordss)
        var loginFlag:Boolean=true

        singUp.setOnClickListener {
            singUp.background = resources.getDrawable(R.drawable.switch_trcks,null)
            singUp.setTextColor(resources.getColor(R.color.textColor,null))
            logIn.background = null
            singIn.text="Sign Up"
            singUpLayout.visibility = View.VISIBLE
            loginFlag=false
            logInLayout.visibility = View.GONE
            logIn.setTextColor(resources.getColor(R.color.pinkColor,null))
        }
        logIn.setOnClickListener {
            singUp.background = null
            singUp.setTextColor(resources.getColor(R.color.pinkColor,null))
            logIn.background = resources.getDrawable(R.drawable.switch_trcks,null)
            singUpLayout.visibility = View.GONE
            logInLayout.visibility = View.VISIBLE
            singIn.text="Log In"
            loginFlag=true
            logIn.setTextColor(resources.getColor(R.color.textColor,null))
        }
        singIn.setOnClickListener {
            if(loginFlag) {
                if (TextUtils.isEmpty(email.text.toString()) && TextUtils.isEmpty(password.text.toString())) {
                    Toast.makeText(this, "Mail and Password is mandatory field", Toast.LENGTH_SHORT)
                        .show()
                }
                else{
                   // Log.d("MainActivity",email.text.trim().toString())
                    startActivity(Intent(this@MainActivity,PolicyList::class.java))
                }
            }
            else{
                if (TextUtils.isEmpty(email.text.toString()) && TextUtils.isEmpty(password.text.toString()) &&TextUtils.isEmpty(confirmPassword.text.toString())) {
                    Toast.makeText(this, "Mail and Password is mandatory field", Toast.LENGTH_SHORT)
                        .show()
                }
                else
                    startActivity(Intent(this@MainActivity,PolicyList::class.java))
            }

        }
    }
}