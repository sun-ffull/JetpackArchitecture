package com.sunfull.databindingwithinclude;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.sunfull.databindingwithinclude.databinding.ActivityMainBinding;
import com.sunfull.databindingwithinclude.databinding.ContactBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ContactBinding binding2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("haechan");
        binding.setUser(user);
    }
}