package com.example.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import android.widget.Toast

class DemoReceiver : BroadcastReceiver() {
    override fun onReceive(ctx: Context?, intent: Intent?) {

        var data = intent?.getStringExtra("key")
        //Log.i("music",data!!)
        if (data == "Music"){
            var i = Intent(ctx,MyService::class.java)
            ctx?.startService(i)
        }

        /*var myIntent = Intent(ctx, MainActivity::class.java)
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        ctx?.startActivity(myIntent)*/
    }
}