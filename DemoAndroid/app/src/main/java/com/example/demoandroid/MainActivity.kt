package com.example.demoandroid

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    val channelId = "notifications"
    val description = "Test notification"
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationBuilder: Notification.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("mytag", "Main Activity created")

        var submitButton = findViewById<Button>(R.id.buttonSubmit)
        var usernameEditText = findViewById<EditText>(R.id.editTextUserName)
        var usernameTextView = findViewById<TextView>(R.id.textViewUserName)

        registerForContextMenu(usernameTextView)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        submitButton.setOnClickListener {

            /*var username = usernameEditText.text.toString()
            Log.i("mytag", username)
            //Toast.makeText(this,"username is $username",Toast.LENGTH_LONG).show()
            //usernameTextView.setText(username)
            var myIntent= Intent(this,MainActivity2::class.java)
            startActivity(myIntent)*/
           /* myIntent.putExtra("keyuser",username)
            var user=User("Manu","abc")
            myIntent.putExtra("keyuser",user)*/
            /* var myIntent=Intent(Intent.ACTION_DIAL, Uri.parse("tel:9492427134"))
            startActivity(myIntent)

            var myIntent=Intent(Intent.ACTION_VIEW ,Uri.parse("http://maps.google.com"))
            startActivity(myIntent)*/
            /* var myIntent=Intent(this,MainActivity::class.java)
            myIntent.addCategory(Intent.CATEGORY_APP_CALCULATOR)
            startActivity(myIntent)
             }
            */

            var myIntent = Intent(this, MainActivity2::class.java)
            val pendingIntent = getActivity(this, 0, myIntent, FLAG_IMMUTABLE)
            if(Build.VERSION.SDK_INT >= 26){
                notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(notificationChannel)
                notificationBuilder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentText("hello?")
                    .setContentTitle("Notifiation ")
                    .setContentIntent(pendingIntent)
            }
            notificationManager.notify(1234, notificationBuilder.build())
        }




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {



        var myid = item.itemId

        if(myid == R.id.mytoast){
            Toast.makeText(this, "Toast Selected", Toast.LENGTH_SHORT).show()
        }

        if(myid == R.id.myact){
            Toast.makeText(this, "Activity Selected", Toast.LENGTH_SHORT).show()
        }

       if(myid == R.id.mysearch){
            Toast.makeText(this, "SEARCHING... ", Toast.LENGTH_SHORT).show()
           var builder = AlertDialog.Builder(this)
               .setTitle("My Alert Dialog")
               .setMessage("do you want to exit the App ?")
               .setCancelable(false)
               .setIcon(R.drawable.alert_icon_foreground)

               .setPositiveButton("Yes", DialogInterface.OnClickListener {
                       dialogInterface, i ->
                   this.finish()
               })
               .setNegativeButton("NO", DialogInterface.OnClickListener {
                       dialogInterface, i ->
               })


           var ad = builder.create()
           ad.show()
       }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.mymenu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var myid = item.itemId
        if(myid == R.id.mytoast){
            Toast.makeText(this, "context item selected", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }


    override fun onStart() {
            super.onStart()
            Log.i("mytag", "Main Activity started")
        }

    override fun onResume() {
            super.onResume()
            Log.i("mytag", "Main Activity resume")
        }

    override fun onPause() {
            super.onPause()
            Log.i("mytag", "Main Activity pause")
        }

    override fun onRestart() {
            super.onRestart()
            Log.i("mytag", "Main Activity restarted")
        }

    override fun onStop() {
            super.onStop()
            Log.i("mytag", "Main Activity stopped")
        }

    override fun onDestroy() {
            super.onDestroy()
            Log.i("mytag", "Main Activity destroy")
        }


    }

