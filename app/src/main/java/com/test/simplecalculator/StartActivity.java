package com.test.simplecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        configure_buttonCalculator();
        configure_buttonConvertor();
    }

    public void configure_buttonCalculator(){
        Button buttonCalculator = (Button) findViewById(R.id.buttonCalculator);
        buttonCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void configure_buttonConvertor(){
        Button buttonConvertor = (Button) findViewById(R.id.buttonConvertor);
        buttonConvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, ConvertActivity.class);
                startActivity(i);
            }
        });
    }
}