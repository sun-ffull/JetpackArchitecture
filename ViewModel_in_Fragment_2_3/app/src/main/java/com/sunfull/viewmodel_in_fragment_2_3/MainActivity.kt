package com.sunfull.viewmodel_in_fragment_2_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = TestFragment()

        manager.beginTransaction()
            .replace(R.id.frameArea, fragment)
            .addToBackStack(null)
            .commit()
    }
}