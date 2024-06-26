package com.sunfull.mapandswitchmap1_3_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sunfull.mapandswitchmap1_3_6.databinding.ActivityMainBinding

// livedata 변경

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.liveCount.observe(this){
            //binding.result1.text = it.toString()
        }

        viewModel.mapLiveData.observe(this){
            binding.result1.text = it.toString()
        }

        viewModel.switchMapLiveData.observe(this){
            binding.result2.text = it.toString()
        }

        binding.btnArea.setOnClickListener {
            val count = binding.inputArea.text.toString().toInt()
            viewModel.setLiveDataValue(count)
        }
    }
}