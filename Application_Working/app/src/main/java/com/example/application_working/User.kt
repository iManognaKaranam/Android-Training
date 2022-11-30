package com.example.application_working

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(var userName:String,var pwd:String,var email:String): Parcelable {

}