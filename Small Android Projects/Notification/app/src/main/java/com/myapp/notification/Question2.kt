package com.myapp.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Question2 : AppCompatActivity() {

    lateinit var tvOptOne: TextView
    lateinit var tvOptTwo: TextView
    lateinit var tvOptThree: TextView
    lateinit var tvOptFour: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        tvOptOne=findViewById(R.id.tv_opt_one)
        tvOptTwo=findViewById(R.id.tv_opt_two)
        tvOptThree=findViewById(R.id.tv_opt_three)
        tvOptFour=findViewById(R.id.tv_opt_three)

    }



}