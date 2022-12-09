package com.dbs.employeeapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dbs.employeeapplication.databinding.ActivityDashboardBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DashboardActivity:AppCompatActivity() {
    private var binding: ActivityDashboardBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarDashboardActivity)

        val actionbar = supportActionBar//actionbar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title = "ADMIN DASHBOARD"
        }

        binding?.toolbarDashboardActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        val dao = (application as EmployeeApp).db.historyDao()
        getAllUsers(dao)
    }

    private fun getAllUsers(historyDao: HistoryDao) {
        lifecycleScope.launch {
            historyDao.fetchALlUsers().collect { allUsersList ->

                if (allUsersList.isNotEmpty()) {
                    binding?.tvHistory1?.visibility = View.VISIBLE
                    binding?.rvHistory1?.visibility = View.VISIBLE
                    binding?.tvNoDataAvailable?.visibility = View.GONE

                    // Creates a vertical Layout Manager
                    binding?.rvHistory1?.layoutManager = LinearLayoutManager(this@DashboardActivity)

                    // History adapter is initialized and the list is passed in the param.users
//                    Log.i("users",allUsersList)
                    val users = ArrayList<String>()
                    for (user in allUsersList) {
                        users.add(user.username.toString())
                    }
                    val dashboardAdapter = DashboardAdapter(ArrayList(users))

                    // Access the RecyclerView Adapter and load the data into it
                    binding?.rvHistory1?.adapter = dashboardAdapter
                } else {
                    binding?.tvHistory1?.visibility = View.GONE
                    binding?.rvHistory1?.visibility = View.GONE
                    binding?.tvNoDataAvailable?.visibility = View.VISIBLE
                }
                // END
            }
        }

    }
}