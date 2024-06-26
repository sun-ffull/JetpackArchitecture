package com.sunfull.viewmodel_2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

/*ViewModel
* 안드로이드 생명 주기 관리가 쉽다.
* onSaveInstanceState() 사용해서 데이터를 관리할 수 있지만 적절하지 않음.
* 안드로이드의 생명 주기를 관리하기 쉽다라는 말과 같은 말인데
* 상태(LifeCycle)가 변경될 때 마다 데이터를 관리해줘야 하는데 이 관리가 편하다.
* UI컨트롤러(Activity, Fragment)에서 모든 것을 다 하려고 하면 복잡해진다.
* 그래서 ViewModel을 사용하면 테스트나 관리가 용이하다.*/

class MainActivity : AppCompatActivity() {

   // private var count = 0

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val btn: Button = findViewById(R.id.plus)
        val btn2: Button = findViewById(R.id.minus)

        var result : TextView = findViewById<TextView>(R.id.result)

        result.text = viewModel.getcount().toString()

        btn.setOnClickListener{
            viewModel.plus()
            result.text = viewModel.getcount().toString()
        //    count++;
        //    result.text = count.toString()
        }
        btn2.setOnClickListener{
            viewModel.minus()
            result.text = viewModel.getcount().toString()
       //    count--;
        //    result.text = count.toString()
        }
    }
}