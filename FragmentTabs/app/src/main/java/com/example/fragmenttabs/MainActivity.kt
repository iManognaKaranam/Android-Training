package com.example.fragmenttabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.example.fragmenttabs.ViewPageAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tab_toolbar = findViewById<Toolbar>(R.id.toolbar)
        var tab_viewpager = findViewById<ViewPager>(R.id.tab_viewpager)
        var tab_tablayout = findViewById<TabLayout>(R.id.tab_tablayout)

        setSupportActionBar(tab_toolbar)
        mysetupViewPager(tab_viewpager)

        tab_tablayout.setupWithViewPager(tab_viewpager)


    }
    fun mysetupViewPager(viewpager: ViewPager) {
        var adapter: ViewPageAdapter = ViewPageAdapter(supportFragmentManager)

        // LoginFragment is the name of Fragment and the Login
        // is a title of tab
        adapter.addFragment(LoginFragment(), "Login")
        adapter.addFragment(SignupFragment(), "Signup")
        adapter.addFragment(HomeFragment(),"Home")
        // setting adapter to view pager.
        viewpager.setAdapter(adapter)
    }
}
