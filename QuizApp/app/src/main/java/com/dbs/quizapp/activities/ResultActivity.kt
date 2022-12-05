package com.dbs.quizapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dbs.quizapp.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val username = findViewById<TextView>(R.id.tv_name)
        username?.text = intent.extras?.getString(Constants.USER_NAME)
        val total = intent.getIntExtra(Constants.TOTAL_QUESTIONS,10)
        val correct = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val score = findViewById<TextView>(R.id.tv_score)
        score?.text= "Your Score is $correct out of $total"

    }
}