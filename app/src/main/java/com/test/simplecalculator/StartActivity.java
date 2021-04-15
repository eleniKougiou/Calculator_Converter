package com.test.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


// Start Activity
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Lock orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        configure_buttonCalculator();
        configure_buttonConverter();
    }

    public void configure_buttonCalculator(){

        // Button for calculator
        Button buttonCalculator = findViewById(R.id.buttonCalculator);
        buttonCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }


    public void configure_buttonConverter(){

        // Button for converter
        Button buttonConverter = findViewById(R.id.buttonConverter);
        buttonConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, ConvertActivity.class);
                startActivity(i);
            }
        });
    }
}