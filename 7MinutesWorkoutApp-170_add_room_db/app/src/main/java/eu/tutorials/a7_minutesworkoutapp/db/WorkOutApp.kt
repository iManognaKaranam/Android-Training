package eu.tutorials.a7_minutesworkoutapp.db

import android.app.Application
import eu.tutorials.a7_minutesworkoutapp.db.HistoryDatabase

//Todo 6 create the application class
class WorkOutApp: Application() {

    val db: HistoryDatabase by lazy {
        HistoryDatabase.getInstance(this)
    }
}