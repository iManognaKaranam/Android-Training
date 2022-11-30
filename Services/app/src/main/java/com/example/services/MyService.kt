package com.example.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    lateinit var  mp : MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service")
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("mytag","Service created")
        mp = MediaPlayer.create(this,R.raw.test)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mp.start()
        Log.i("mytag","Service started")
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onDestroy() {

        super.onDestroy()
        mp.stop()
        Log.i("mytag","Service destroyed")
    }
}