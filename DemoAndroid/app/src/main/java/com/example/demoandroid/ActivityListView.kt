package com.example.demoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ActivityListView : AppCompatActivity() {

    var teams=arrayOf("INDIA","GERMANY","USA","JAPAN","CHINA")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        var mylistview = findViewById<ListView>(R.id.listviewItem)

        //var myadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,teams)
        var myadapter = ArrayAdapter(this, R.layout.itemlayout, R.id.textViewItem,teams)
        mylistview.adapter = myadapter
        // test
        mylistview.setOnItemClickListener { adapterView, view, pos, id ->
            var item = adapterView.getItemAtPosition(pos).toString()
            Toast.makeText(this, "you clicked $item", Toast.LENGTH_SHORT).show()
        }

    }
}