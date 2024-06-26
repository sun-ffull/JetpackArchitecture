package com.sunfull.coroutineandviewmodelscope_4_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn1)
        btn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        /*Log.d("test", "start")
        CoroutineScope(Dispatchers.IO).launch{
            a()
            b()
        }
        Log.d("test", "end")*/

    }
    suspend fun a(){
        delay(1000)
        Log.d("test", "ap1")
        delay(1000)
        Log.d("test", "ap2")
    }
    suspend fun b(){
        delay(1000)
        Log.d("test", "bp1")
        delay(1000)
        Log.d("test", "bp2")
    }
}