package com.webtos.calculatorbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.webtos.calculatorbmi.databinding.ActivityCalculateBmiBinding;
import com.webtos.calculatorbmi.databinding.ActivityMainBinding;

import java.text.DateFormat;
import java.util.Calendar;

public class CalculateBMI extends AppCompatActivity {

    ActivityCalculateBmiBinding bmiBinding;
    private Intent intent;
    private String mbmi;
    private float intbmi;
    private String height;
    private String weight;
    private float int_height;
    private float int_weight;
        private Calendar calendar;
        private String current_Date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       bmiBinding =  ActivityCalculateBmiBinding.inflate(getLayoutInflater());
        setContentView(bmiBinding.getRoot());

            intent = getIntent();

            // Calender

        calendar = Calendar.getInstance();
            current_Date = DateFormat.getDateInstance().format(calendar.getTime());

         // Coding
        try {

            height =  intent.getStringExtra("height");
            weight = intent.getStringExtra("weight");
            int_height =  Float.parseFloat(height) ;
            int_weight = Float.parseFloat(weight);



            int_height = int_height/100;

            intbmi = int_weight/(int_height*int_height);


            mbmi=Float.toString(intbmi);
        }catch (NullPointerException e)
        {
                return ;

        }










        if(intbmi   < 18.5)
        {

            bmiBinding.textViewCondition.setText("Underweight");
            bmiBinding.textViewCondition.setBackgroundColor(Color.BLUE);
            bmiBinding.textViewResult.setText(String.valueOf(intbmi));



        }

        else if(intbmi >= 18.5 && intbmi < 25 )

        {
            bmiBinding.textViewCondition.setText("Normal");
            bmiBinding.textViewCondition.setBackgroundColor(Color.GREEN);
            bmiBinding.textViewResult.setText(String.valueOf(intbmi));

        }


        else if(intbmi >= 25  && intbmi < 30  )

        {
            bmiBinding.textViewCondition.setText("Moderate");
            bmiBinding.textViewCondition.setBackgroundColor(Color.GREEN);
            bmiBinding.textViewResult.setText(String.valueOf(intbmi));

        }




        else if(intbmi >= 30)

        {
            bmiBinding.textViewCondition.setText("Obese Class 1");
            bmiBinding.textViewCondition.setBackgroundColor(Color.RED);

            bmiBinding.textViewResult.setText(String.valueOf(intbmi));

        }




        bmiBinding.buttonRecalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });





        // Result Save

       bmiBinding.buttonSaveResult.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


           }
       });
    }
}