package com.sunfull.databindinganddataclass_1_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sunfull.databindinganddataclass_1_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var testCount = 24

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //기존 방법
        //binding.test.text = "바뀐 텍스트"

        //데이터 결합.
        val person = Person("haechan", 24)
        binding.user = person
    }

    fun myClick(view: View){
        Log.d("test", "onClick")
        testCount++

        val person = Person("haechan", testCount)
        binding.user = person
    }
}