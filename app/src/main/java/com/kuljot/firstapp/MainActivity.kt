package com.kuljot.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogIn: Button
    lateinit var txtForgetPassword: TextView
    lateinit var txtRegisterYourself: TextView
    lateinit var toolbar: Toolbar

    val validMobileNumber="0123456789"
    val validPassword=arrayOf("hello","welcome","mohan@123")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpToolbar()
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogIn = findViewById(R.id.btnLogIn)
        txtForgetPassword = findViewById(R.id.txtForgetPassword)
        txtRegisterYourself = findViewById(R.id.txtRegisterYourself)
        toolbar=findViewById(R.id.LogInToolbar)
        btnLogIn.setOnClickListener{
            val intent=Intent(this@MainActivity,NavigatorActivity::class.java)
            val mobileNumber=etMobileNumber.text.toString()
            val password=etPassword.text.toString()
            if ((mobileNumber==validMobileNumber)){
                if(validPassword.contains(password)){
                    startActivity(intent)
                }
                else
                    Toast.makeText(this@MainActivity,"Incorrect Password", Toast.LENGTH_SHORT).show()

            }
            else
                Toast.makeText(this@MainActivity,"Incorrect Mobile Number", Toast.LENGTH_SHORT).show()

        }
        txtForgetPassword.setOnClickListener{
            Toast.makeText(this@MainActivity,"Forget Password Clicked", Toast.LENGTH_SHORT).show()
        }
        txtRegisterYourself.setOnClickListener{
            Toast.makeText(this@MainActivity,"Register Yourself Clicked", Toast.LENGTH_SHORT).show()
        }


    }

    fun setUpToolbar(){
        setSupportActionBar(LogInToolbar)
        supportActionBar?.title="Log In"
    }
}
