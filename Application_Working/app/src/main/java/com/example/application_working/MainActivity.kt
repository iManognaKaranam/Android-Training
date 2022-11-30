package com.example.application_working

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var submitButton=findViewById<Button>(R.id.buttonSubmit)
        var usernameEditText=findViewById<EditText>(R.id.editTextUserName)
        var passwordEditText=findViewById<EditText>(R.id.editTextPassword)
        var signUpButton=findViewById<TextView>(R.id.textViewLogout)

        submitButton.setOnClickListener {
            var username=usernameEditText.text.toString()
            var password=passwordEditText.text.toString()

            if(username=="DBS" && password=="123")
                {
                    var myIntent= Intent(this,MainActivity2::class.java)
                    myIntent.putExtra("keyuser",username)
                    myIntent.putExtra("keypass",password)
                    startActivity(myIntent)
                }
            else{
                Toast.makeText(this,"Invalid Credentials!!", Toast.LENGTH_LONG).show()
            }

        }
        signUpButton.setOnClickListener {
            var myIntent=Intent(this,MainActivity4::class.java)
        }

    }
}