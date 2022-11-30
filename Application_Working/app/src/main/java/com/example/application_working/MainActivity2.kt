package com.example.application_working

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var userNameText=findViewById<TextView>(R.id.textViewUserName)
        var passwordText=findViewById<TextView>(R.id.textViewPassword)
        var res=intent.extras?.getString("keyuser")
        var res1=intent.extras?.getString("keypass")
        userNameText.text=res
        passwordText.text=res1

        var homeButton=findViewById<Button>(R.id.buttonHome)
        homeButton.setOnClickListener {
            var myIntent= Intent(this,MainActivity::class.java)
            startActivity(myIntent)
        }

        var nextButton=findViewById<Button>(R.id.buttonNext)
        nextButton.setOnClickListener {
            var myIntent= Intent(this,MainActivity3::class.java)
            startActivity(myIntent)
        }


    }
}