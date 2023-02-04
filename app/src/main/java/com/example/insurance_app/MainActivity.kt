package com.example.insurance_app

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences:SharedPreferences
    lateinit var sharedPreferencesEditor: Editor
    lateinit var sharedPreferencesLogin:SharedPreferences
    lateinit var sharedPreferencesLoginEditor: Editor
    val credentials=Credentials()
    var isValid:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val singUp:TextView=findViewById(R.id.singUp)
        val logIn:TextView=findViewById(R.id.logIn)
        val singUpLayout:LinearLayout=findViewById(R.id.singUpLayout)
        val logInLayout:LinearLayout=findViewById(R.id.logInLayout)
        val singIn:Button=findViewById(R.id.singIn)
        val email:EditText=findViewById(R.id.eMail)
        val signupeMail:EditText=findViewById(R.id.signupeMails)
        val password:EditText=findViewById(R.id.passwords)
        val signupPassword:EditText=findViewById(R.id.passwordss)
        val confirmPassword:EditText=findViewById(R.id.confirmpasswords)
        var loginFlag:Boolean=true
        sharedPreferences=application.getSharedPreferences("CredentialsDB", MODE_PRIVATE)
        sharedPreferencesEditor=sharedPreferences.edit()

        sharedPreferencesLogin = getSharedPreferences("login",MODE_PRIVATE);
        if(sharedPreferencesLogin.getBoolean("logged",false)){
            goToUserDashboardActivity();
        }
        if(sharedPreferences!=null){
            var preferencesMap:Map<String,*> = sharedPreferences.all as Map<String, String>
            if(preferencesMap.size!=0)
                credentials.loadCredentials(preferencesMap)
            for(i in preferencesMap){
                Log.d("MainActivity ","MAP -> key= ${i.key} value = ${i.value}")
            }
        }

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
                    checkUserDetails(email.text.toString(),password.text.toString())
                }
                Log.d("MainActivity ","From LogIn -> UserName = ${email.text.toString()} UserPassword = ${password.text.toString()} confirm pass= ${confirmPassword.text.toString()}")
            }
            else{
                if (TextUtils.isEmpty(signupeMail.text.toString()) && TextUtils.isEmpty(signupPassword.text.toString()) &&TextUtils.isEmpty(confirmPassword.text.toString())) {
                    Toast.makeText(this, "Mail and Password is mandatory field", Toast.LENGTH_SHORT)
                        .show()
                }
                else if((signupPassword.text.toString()) != (confirmPassword.text.toString())){
                    Toast.makeText(this, "Passwords are not matching", Toast.LENGTH_SHORT)
                        .show()
                }
                else{
                    addUserLoginData(signupeMail.text.toString(),signupPassword.text.toString())
                }
                Log.d("MainActivity ","From Signup -> UserName = ${signupeMail.text.toString()} UserPassword = ${password.text.toString()} confirm pass= ${confirmPassword.text.toString()}")
            }
        }
    }

    private fun goToUserDashboardActivity() {
        startActivity(Intent(this@MainActivity,UserDashboardActivity::class.java))
        finish()
    }

    private fun addUserLoginData(userName: String, userPassword: String) {

        if (credentials.checkUsername(userName)) {
            Toast.makeText(this@MainActivity, "Username already taken!", Toast.LENGTH_SHORT)
                .show()
        } else {
            credentials.addCredentials(userPassword, userPassword)

            sharedPreferencesEditor.putString(userName, userPassword)
            sharedPreferencesEditor.putString("LastSavedUsername", "")
            sharedPreferencesEditor.putString("LastSavedPassword", "")

            sharedPreferencesEditor.apply()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
//            sharedPreferencesLogin.edit().putBoolean("logged",true).apply();
        }

    }

    private fun checkUserDetails(userName: String, userPassword: String) {

        isValid = validate(userName, userPassword);

        if(!isValid){
            Toast.makeText(this, "Incorrect credentials entered!", Toast.LENGTH_SHORT).show();
            }
        else {
            Toast.makeText(this@MainActivity, "Login successful!", Toast.LENGTH_SHORT).show()
            sharedPreferencesEditor.putString("LastSavedUsername", userName)
            sharedPreferencesEditor.putString("LastSavedPassword", userPassword)
            sharedPreferencesEditor.apply()

            goToUserDashboardActivity()
            sharedPreferencesLogin.edit().putBoolean("logged",true).apply();
        }

    }

    private fun validate(name:String,password:String): Boolean {
        return credentials.checkCredentials(name, password);
    }
}