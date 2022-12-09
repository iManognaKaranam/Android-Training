package com.dbs.employeeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.dbs.employeeapplication.databinding.ActivityMainBinding
import com.dbs.employeeapplication.databinding.ActivitySignInBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class SignInActivity : AppCompatActivity() {

    private var binding: ActivitySignInBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarSignin)
        supportActionBar?.title = "SignIn"
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarSignin?.setNavigationOnClickListener {
            onBackPressed()
        }
        binding?.btnLogin?.setOnClickListener {
            var email = binding?.etSigninEmail?.text.toString()
            Log.i("Email", email)
            var password = binding?.etSigninPassword?.text.toString()
            Log.i("Email", password)

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Fields cannot be empty!", Toast.LENGTH_LONG).show()
            } else {
                if (adminValidator(email, password)) {
                    var intent1 = Intent(this, DashboardActivity::class.java)

                    startActivity(intent1)
                } else {
                    if (!(emailValidator(email) && passwordValidator(password))) {
                        Toast.makeText(this, "Email or Password is Invalid", Toast.LENGTH_LONG)
                            .show()
                    } else {
                        val intent = Intent(this, CreateProfileActivity::class.java)

                        val dao = (application as EmployeeApp).db.historyDao()
                        addDateToDatabase(dao)

                        startActivity(intent)
                    }
                }
            }
        }


    }

    fun emailValidator(email: String): Boolean {
        return (android.util.Patterns.EMAIL_ADDRESS.matcher(email)
            .matches())

    }

    fun passwordValidator(password: String): Boolean {
        val passwordPattern =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$"
        val passwordMatcher = Regex(passwordPattern)
        return passwordMatcher.matches(password)
    }

    fun adminValidator(email: String, password: String): Boolean {
        return (email.equals("admin") && password.equals("admin"))
    }


    private fun addDateToDatabase(historyDao: HistoryDao) {

        val c = Calendar.getInstance() // Calendars Current Instance
        val dateTime = c.time // Current Date and Time of the system.
        Log.e("Date : ", "" + dateTime) // Printed in the log.

        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault()) // Date Formatter
        val date = sdf.format(dateTime) // dateTime is formatted in the given format.
        Log.e("Formatted Date : ", "" + date) // Formatted date is printed in the log.

        lifecycleScope.launch {
            historyDao.insert(HistoryEntity(date)) // Add date function is called.
            Log.e(
                "Date : ",
                "Added..."
            ) // Printed in log which is printed if the complete execution is done.
        }
    }

    }