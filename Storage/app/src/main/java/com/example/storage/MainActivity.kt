package com.example.storage

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var animation = findViewById<TextView>(R.id.textViewAnim)
        var anim = AnimationUtils.loadAnimation(this, R.anim.blink)
        animation.startAnimation(anim)

        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

        lateinit var sp : SharedPreferences

        var usernameEditText = findViewById<EditText>(R.id.editTextName)
        var passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        var submitButton = findViewById<Button>(R.id.buttonSubmit)
        var checkBox = findViewById<CheckBox>(R.id.checkBox)

        val securePreferences = EncryptedSharedPreferences.create(
            "myfile",
            mainKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )


        sp = getSharedPreferences("myfile", MODE_PRIVATE)
        submitButton.setOnClickListener {
            var username = usernameEditText.text.toString()
            var password = passwordEditText.text.toString()
            var editor = securePreferences.edit()
            if(checkBox.isChecked){
                editor.putString("keyun", username)
                editor.putString("keypa",password)
                editor.commit()
            }
            else{
                usernameEditText.setText(sp.getString("keyun",""))
                passwordEditText.setText(sp.getString("keypas",""))
            }

        }

    }
}