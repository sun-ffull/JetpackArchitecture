package com.sunfull.livedatainfragmentandviewlifecyclerowner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunfull.livedatainfragmentandviewlifecyclerowner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {
            val fragment1 = Blank1Fragment()
            manager.beginTransaction()
                .replace(R.id.frameArea, fragment1)
                .addToBackStack(null)
                .commit()
        }

        binding.btn2.setOnClickListener {
            val fragment2 = Blank2Fragment()
            manager.beginTransaction()
                .replace(R.id.frameArea, fragment2)
                .addToBackStack(null)
                .commit()
        }
    }
}