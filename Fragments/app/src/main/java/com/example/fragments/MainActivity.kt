package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var RedButton = findViewById<Button>(R.id.buttonRed)
        var BlueButton = findViewById<Button>(R.id.buttonBlue)

        RedButton.setOnClickListener {

            var redFragment = RedFragment()
            var manager = supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.fragmentContainerViewGreen, redFragment)
            transaction.commit()
        }

        BlueButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewGreen,BlueFragment()).commit()
        }
    }
}