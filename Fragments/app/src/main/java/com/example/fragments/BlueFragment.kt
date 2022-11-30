package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class BlueFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.blue_layout, container, false)
        var resTextView1 = view.findViewById<TextView>(R.id.textViewNameBlue)
        var resTextView2 = view.findViewById<TextView>(R.id.textViewPasswordBlue)

        var data1 =   arguments?.getString("key1")
        var data2= arguments?.getString("key2")
        resTextView1.setText(data1)
        resTextView2.setText(data2)
        return view
    }
}