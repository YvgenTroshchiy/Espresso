package com.troshchiy.espresso

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        btn_next.setOnClickListener {
            startActivity<SecondActivity>(SecondActivity.EXTRA_NAME to edt_name.text.toString())
        }
    }
}