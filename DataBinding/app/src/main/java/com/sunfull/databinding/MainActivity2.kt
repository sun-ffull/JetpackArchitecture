package com.sunfull.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val fragment = TestFragment()
        manager.beginTransaction()
            .replace(R.id.framearea, fragment)
            .addToBackStack(null)
            .commit()
    }
}