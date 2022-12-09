package com.dbs.employeeapplication

import android.app.Application
// create the application class
class EmployeeApp: Application() {

    val db:HistoryDatabase by lazy {
        HistoryDatabase.getInstance(this)
    }
}