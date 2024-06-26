package com.sunfull.shareviewmodel_activity_fragment_2_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.sunfull.shareviewmodel_activity_fragment_2_4.databinding.FragmentTestBinding

class TestFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding: FragmentTestBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)

        binding.result.text = viewModel.getCount().toString()

        return binding.root
    }
}