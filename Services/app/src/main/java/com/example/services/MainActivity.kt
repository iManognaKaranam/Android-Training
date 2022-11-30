package com.example.services

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startButton = findViewById<Button>(R.id.buttonStart)
        var stopButton = findViewById<Button>(R.id.buttonStop)

        var musicIntent = IntentFilter("demo_action")
        var musicReceiver = DemoReceiver()
        registerReceiver(musicReceiver,musicIntent)

        startButton.setOnClickListener {
            var i = Intent(this, MyService::class.java)
            startService(i)
        }

        stopButton.setOnClickListener {
            var i = Intent(this, MyService::class.java)
            stopService(i)
        }
    }
}