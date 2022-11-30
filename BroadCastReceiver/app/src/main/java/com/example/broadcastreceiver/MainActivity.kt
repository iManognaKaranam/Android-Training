package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var myIntentFilter = IntentFilter("android.intent.action.AIRPLANE_MODE")

        var myIntentFilter = IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        var myReceiver = MyReceiver()
        registerReceiver(myReceiver, myIntentFilter)

        /*if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"PERMISSION GRANTED",Toast.LENGTH_LONG).show()
        }
        else{
            ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.RECEIVE_SMS),123)
        }*/

        //music code
        var send = findViewById<Button>(R.id.buttonSend)
        send.setOnClickListener {
            var myIntent = Intent()
            Toast.makeText(this, "Music Initiated", Toast.LENGTH_SHORT).show()
            myIntent.putExtra("key", "Music")
            myIntent.action="demo_action"
            sendBroadcast(myIntent)
        }

    }
}