package com.dbs.employeeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.dbs.employeeapplication.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.launch

class RegistrationActivity : AppCompatActivity() {
    private var binding:ActivityRegistrationBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarRegister)
        supportActionBar?.title="Registration"
        if (supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarRegister?.setNavigationOnClickListener {
            onBackPressed()
        }

        binding?.btnRegister?.setOnClickListener {

            val fname = binding?.etFirstName?.text.toString()
            val lname = binding?.etLastName?.text.toString()
            val email = binding?.etEmail?.text.toString()
            val password = binding?.etPassword?.text.toString()
            var flag = true
            if(nameValidator(fname) || nameValidator(lname)){
                flag=false
            }
            if(!emailValidator(email)){
                flag=false
            }
            if(!passwordValidator(password)){
                flag=false
            }
            if(flag){
                val intent = Intent(this,SignInActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Fields doesn't match the criteria!!",Toast.LENGTH_LONG).show()
            }
            val dao = (application as EmployeeApp).db.historyDao()
            addUserToDatabase(dao)
        }

    }

    fun nameValidator(name : String):Boolean{
        val namePattern = "^$"
        val nameMatcher = Regex(namePattern)
        return nameMatcher.matches(name)
    }

    fun emailValidator(email : String):Boolean{
        return (!TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())

    }

    fun passwordValidator(password : String):Boolean{
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$"
        val passwordMatcher = Regex(passwordPattern)
        return passwordMatcher.matches(password)
    }
    private fun addUserToDatabase(historyDao: HistoryDao) {
        var username = binding?.etFirstName?.text.toString()
        lifecycleScope.launch{
            historyDao.insert(DashboardEntity(username))
        }

    }
}