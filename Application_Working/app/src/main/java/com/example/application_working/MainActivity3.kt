package com.example.application_working

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var textViewLogout=findViewById<TextView>(R.id.textViewLogout)
        textViewLogout.setOnClickListener {
            var myIntent= Intent(this,MainActivity::class.java)
            startActivity(myIntent)
        }
    }
}