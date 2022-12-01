package com.example.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stu_tb")
class Student {

    @PrimaryKey (autoGenerate = true )
    var id : Int = 0


    //@ColumnInfo(name = "un")
    var username : String = ""

    var password : String = ""
}