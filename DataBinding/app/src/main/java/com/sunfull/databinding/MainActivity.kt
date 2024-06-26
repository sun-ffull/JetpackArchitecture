package com.sunfull.databinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sunfull.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.dataBindingEx.text = "바뀐 텍스트"
        binding.dataBindingEx.setOnClickListener{     //이게 가능한 이유는 View.OnClickListener가 '단일 추상 메서드를 갖는' fun interface이기 때문
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        /*binding.dataBindingEx.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, MainActivity2::class.java)
                startActivity(intent)
            }
        })*/
    }
}