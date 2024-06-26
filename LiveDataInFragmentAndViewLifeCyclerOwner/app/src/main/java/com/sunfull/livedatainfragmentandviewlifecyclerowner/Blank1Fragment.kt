package com.sunfull.livedatainfragmentandviewlifecyclerowner

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sunfull.livedatainfragmentandviewlifecyclerowner.databinding.FragmentBlank1Binding

class Blank1Fragment : Fragment() {

    private var _binding : FragmentBlank1Binding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : BlankViewModel1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentBlank1Binding.inflate(inflater, container, false)
        val view = binding.root

        //viewModel 수명주기 : fragment
        viewModel = ViewModelProvider(this).get(BlankViewModel1::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            viewModel.plusCountValue()
        }

        //observer 수명주기 : fragmentView
        viewModel.liveCount.observe(viewLifecycleOwner, Observer{
            binding.tv1.text = it.toString()
            Log.d("tag","!!")
        })
    }

}