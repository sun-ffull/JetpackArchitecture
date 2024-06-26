package com.sunfull.shareviewmodel_activity_fragment_2_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sunfull.shareviewmodel_activity_fragment_2_4.databinding.ActivityMainBinding

/*ViewModel -> Activity/Fragment 공유
* 이유 -> Activity의 값을 Fragment에서 쓰고 싶거나
* Fragment에서 값을 ViewModel의 값으로 사용하기 위해서*/

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.result.text = viewModel.getCount().toString()

        binding.plus.setOnClickListener{
            viewModel.plus()
            binding.result.text = viewModel.getCount().toString()
        }

        binding.minus.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                viewModel.minus()
                binding.result.text = viewModel.getCount().toString()
            }
        })

        val manager = supportFragmentManager
        binding.showFragment.setOnClickListener{
            val fragment = TestFragment()
            manager.beginTransaction()
                .replace(R.id.framearea, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}