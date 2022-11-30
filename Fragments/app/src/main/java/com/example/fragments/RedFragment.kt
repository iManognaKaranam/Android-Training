package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class RedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.red_layout, container, false)
        var redBut = view.findViewById<Button>(R.id.buttonNextRed)
        redBut.setOnClickListener {

            var userName=view.findViewById<EditText>(R.id.editTextNameRed).text.toString()
            var password=view.findViewById<EditText>(R.id.editTextPasswordRed).text.toString()

           /*Log.i("mytag","username : $userName")
           Log.i("mytag","pass : $password")*/

            var blueFrag = BlueFragment()
            var bundle = Bundle()
            bundle.putString("key1", userName)
            bundle.putString("key2",password)
            blueFrag.arguments = bundle

            fragmentManager?.beginTransaction()?.replace(R.id.dynamicfragment, blueFrag)?.addToBackStack(null)?.commit()
        }

        return view
    }

}