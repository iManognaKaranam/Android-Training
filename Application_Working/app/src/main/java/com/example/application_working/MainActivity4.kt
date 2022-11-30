package com.example.application_working

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        var userName=findViewById<EditText>(R.id.editTextUserName).toString()
        var password=findViewById<EditText>(R.id.editTextPassword).toString()
        var email=findViewById<EditText>(R.id.editTextEmail).toString()

        var registerButton=findViewById<Button>(R.id.buttonRegister)

        registerButton.setOnClickListener {
            var myIntent=Intent(this,MainActivity5::class.java)
            var userData=User(userName,password,email)
            myIntent.putExtra("keyuser_data",userData)
            startActivity(myIntent)
        }

    }
}