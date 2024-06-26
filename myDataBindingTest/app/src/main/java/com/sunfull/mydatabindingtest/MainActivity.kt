package com.sunfull.mydatabindingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sunfull.mydatabindingtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel
    lateinit var myViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        myViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.myViewModel = myViewModel

        val fruits: List<Apple> = listOf(Apple(), Apple())
        receiveFruits(fruits)   // Number of fruits: 2
        val test = listOf<Int>()

        mymethod(myinter {  })
        mymethod(object : myinter{
            override fun myfun() {
                TODO("Not yet implemented")
            }
        })
        mymethod({})
        mymethod{}
    }
}

fun interface myinter {
    fun myfun()
}

fun mymethod(myinter: myinter){

}