package com.example.demoandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(var userName:String,var pwd:String):Parcelable{

}