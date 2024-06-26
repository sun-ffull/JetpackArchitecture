package com.sunfull.livedata2_3_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)      //this는 lifeCycler owner로 액티비티 혹은 프래그먼트 의미

        findViewById<Button>(R.id.btn).setOnClickListener {
            viewModel.plusLiveDataValue()
        }

        viewModel.testLiveData.observe(this, Observer{
            findViewById<TextView>(R.id.textArea).text = it.toString()
        })

        //viewModel.testLiveData.value = 10

        //findViewById<Button>(R.id.btn).setOnClickListener {
        //    viewModel.plusLiveDataValue()
        //}

        //viewModel.testMutableLiveData.observe(this, Observer {
        //    findViewById<TextView>(R.id.textArea).text = viewModel.testMutableLiveData.value.toString()
        //})
    }
}