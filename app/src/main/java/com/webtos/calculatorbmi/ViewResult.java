package com.webtos.calculatorbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.webtos.calculatorbmi.databinding.ActivityViewResultBinding;

public class ViewResult extends AppCompatActivity {

    ActivityViewResultBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewResultBinding.inflate(getLayoutInflater() );
        setContentView(binding.getRoot());


    }
}