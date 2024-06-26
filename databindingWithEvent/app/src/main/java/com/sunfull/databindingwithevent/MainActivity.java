package com.sunfull.databindingwithevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.sunfull.databindingwithevent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //ActivityMainBinding.bind();
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MyHandlers myHandlers = new MyHandlers(this);

        binding.setHandlers(myHandlers);
    }
}