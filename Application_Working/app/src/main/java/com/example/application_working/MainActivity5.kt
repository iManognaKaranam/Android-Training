package com.example.application_working

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        var UserData_username=findViewById<TextView>(R.id.textViewUserName_User)
        var UserData_password=findViewById<TextView>(R.id.textViewPassword_User)
        var UserData_email=findViewById<TextView>(R.id.textViewUserName_User)

        var un=intent.getParcelableExtra<User>("keyuser_data")


        UserData_username.text=un?.userName
        UserData_password.text=un?.pwd
        UserData_email.text=un?.email

    }
}