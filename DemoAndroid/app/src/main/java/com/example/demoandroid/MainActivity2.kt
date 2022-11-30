package com.example.demoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("mytag", "second Activity created")
        setContentView(R.layout.activity_main2)
        /*var Activity1Text=findViewById<TextView>(R.id.textViewResult)
        var res=intent.extras?.getString("keyuser")
        Activity1Text.text=res

        var ObjectText=findViewById<TextView>(R.id.textViewObject)
        var res1=intent.getParcelableExtra<User>("keyuser")

        ObjectText.text=res1?.userName*/


    }
    override fun onStart() {
        super.onStart()
        Log.i("mytag", "second Activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("mytag", "second Activity resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("mytag", "second Activity pause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("mytag", "second Activity restarted")
    }

    override fun onStop() {
        super.onStop()
        Log.i("mytag", "second Activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("mytag", "second Activity destroy")
    }
}