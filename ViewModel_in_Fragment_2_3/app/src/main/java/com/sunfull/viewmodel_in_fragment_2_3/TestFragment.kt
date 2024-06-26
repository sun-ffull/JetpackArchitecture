package com.sunfull.viewmodel_in_fragment_2_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunfull.viewmodel_in_fragment_2_3.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private lateinit var binding : FragmentTestBinding

    //var count = 0

    private lateinit var viewmodel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)

        viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.result.text = viewmodel.getcount().toString()

        binding.plus.setOnClickListener{
            viewmodel.plus()
        //    count++
            binding.result.text = viewmodel.getcount().toString()
        }

        binding.minus.setOnClickListener{
            viewmodel.minus()
        //    count--
            binding.result.text = viewmodel.getcount().toString()
        }

        return binding.root
    }

}