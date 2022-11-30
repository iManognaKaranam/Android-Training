package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.speech.tts.TextToSpeech
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast
import java.util.*

class MyReceiver : BroadcastReceiver() , TextToSpeech.OnInitListener {

    lateinit var tts: TextToSpeech
    lateinit var myMessage : String

    override fun onReceive(ctx: Context?, intent: Intent?) {

        //Toast.makeText(ctx,"AIRPLANE MODE ", Toast.LENGTH_LONG).show()
        /*var myIntent = Intent(ctx, MainActivity::class.java)
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        ctx?.startActivity(myIntent)*/

        tts = TextToSpeech(ctx,this)
        var bundle = intent?.extras
        if (bundle != null) {

            var pdusObj = bundle["pdus"] as Array<Any>
            for (i in pdusObj.indices) {
                val currentMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray)
                myMessage = currentMessage.displayMessageBody
                tts.speak(myMessage, TextToSpeech.QUEUE_FLUSH , null ,"")
                val receiverPh = currentMessage.originatingAddress
                Toast.makeText(ctx, "message is $myMessage and sender is : $receiverPh", Toast.LENGTH_LONG).show()
                Log.i("mytag", "message is $myMessage and sender is : $receiverPh")
            }

        }
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            } else {
                tts?.speak(myMessage, TextToSpeech.QUEUE_FLUSH, null ,"")
            }

        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }
}