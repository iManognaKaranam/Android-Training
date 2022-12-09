package com.dbs.employeeapplication

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dashboard-table")
data class DashboardEntity(
    @PrimaryKey
    val username:String )
