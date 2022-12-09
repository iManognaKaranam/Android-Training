package com.dbs.employeeapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.dbs.employeeapplication.databinding.ActivityCreateProfileBinding

class CreateProfileActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener{
    private var binding:ActivityCreateProfileBinding ?= null
    val professionalStatus = arrayOf<String?>("Professional Status","Student","Junior Developer","Instructor","Manager","Instructor","Senior Developer")
    val skillSet = arrayOf<String>("Java","React","SpringBoot")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateProfileBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarCreateProfile)
        supportActionBar?.title="Create Profile"
        if (supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarCreateProfile?.setNavigationOnClickListener {
            onBackPressed()
        }

        val spin = binding?.spProfessionalStatus
        spin?.onItemSelectedListener=this
        val professionalAdapter : ArrayAdapter<*> = ArrayAdapter<Any?>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,professionalStatus)
        professionalAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        spin?.adapter= professionalAdapter

        binding?.btnSubmit?.setOnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

      



    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}