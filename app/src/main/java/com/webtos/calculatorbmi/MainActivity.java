package com.webtos.calculatorbmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.webtos.calculatorbmi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    private ActivityMainBinding binding;
   
    private int height ;
    private int weight = 40 ;
    private String weight_string = "40";
    private String age_string = "40";
    private int age = 40;
    private int current_progress;
    private String progress_bar = "180";
    private String type_user = "0";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



            binding.seekBar.setMax(300);
            binding.seekBar.setProgress(180);



        // Code Here


            binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override                                           // 200
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    current_progress = progress;
                    progress_bar =  String.valueOf(current_progress);

                   binding.textViewNumber.setText(progress_bar);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });







        binding.imageDecrementWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                weight = weight-1;

                weight_string =  String.valueOf(weight);

                binding.textViewWeight.setText(weight_string);


            }
        });



        binding.imageIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                weight = weight+1;

                weight_string =  String.valueOf(weight);

                binding.textViewWeight.setText(weight_string);


            }
        });


        // Age Code
        binding.imageAgeIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                age = age+1;

                age_string =  String.valueOf(age);

                binding.textViewAge.setText(age_string);


            }
        });



        binding.imageAgeDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                age = age-1;

                age_string =  String.valueOf(age);

                binding.textViewAge.setText(age_string);


            }
        });




            binding.imageViewMale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    type_user = "Male";
                    binding.imageViewMale.setBackgroundColor(Color.RED);
               //     Log.d("tag","okay");
                }
            });


        binding.imageViewFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                type_user = "Female";

                binding.imageViewFemale.setBackgroundColor(Color.GREEN);
           //     Log.d("tag","fine");
            }
        });




        binding.buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(type_user.equals("0"))
                {

                    Toast.makeText(MainActivity.this, "Please Select Your Gender", Toast.LENGTH_SHORT).show();
                }


                else if(progress_bar.equals("0"))
                {

                    Toast.makeText(MainActivity.this, "Height Must be Greater Than 0 ", Toast.LENGTH_SHORT).show();
                }



                else if(age ==0 || age <0 )
                {

                    Toast.makeText(MainActivity.this, "Age Must be Greater Than 0", Toast.LENGTH_SHORT).show();
                }

                else if(weight ==0 || weight <0 )
                {

                    Toast.makeText(MainActivity.this, "Weight Must be Greater Than 0", Toast.LENGTH_SHORT).show();
                }

                else
                {

                    Intent intent = new Intent(getApplicationContext() , CalculateBMI.class);
                    intent.putExtra("gender", type_user);
                    intent.putExtra("height", progress_bar);
                    intent.putExtra("weight", weight_string);
                    intent.putExtra("age", age_string);
                    startActivity(intent);
                }





            }
        });
    }
}