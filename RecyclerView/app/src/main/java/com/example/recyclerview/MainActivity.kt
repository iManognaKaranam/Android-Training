package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
        lateinit var myUserList : ArrayList<User>
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            var myRecyclerView = findViewById<RecyclerView>(R.id.myrv)
            //myRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            myRecyclerView.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

            myUserList = ArrayList<User>()
            var myAdapter = MyAdapter(myUserList)
            myRecyclerView.adapter = myAdapter

            addUserData()

        }

        private fun addUserData() {

            var u1 = User("Manu", "123")
            myUserList.add(u1)

            var u2 = User("Nishu", "456")
            myUserList.add(u2)

            var u3 = User("Ajay", "789")
            myUserList.add(u3)


        }
    }
