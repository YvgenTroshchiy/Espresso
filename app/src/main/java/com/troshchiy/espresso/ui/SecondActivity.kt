package com.troshchiy.espresso.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.troshchiy.espresso.R
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity : AppCompatActivity() {

    companion object {
        val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        intent?.let {
            val name = it.getStringExtra(EXTRA_NAME)
            tv_name.text = name
        }
    }
}