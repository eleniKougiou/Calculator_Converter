package com.test.simplecalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Arrays;


public class ConvertActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText txt_amount;
    Button convertBtn;
    Spinner spinnerTo, spinnerFrom;
    TextView textResult;
    ImageView imageView;
    String textTo, textFrom;
    double amount;
    double final_toRate;
    double final_result;
    private static final String VOLLEY_URL = "http://data.fixer.io/api/latest?access_key=038674f3a04897967685ce8bc9114497";
    private RequestQueue mQueue;
    private long backPressedTime;
    private Toast backToast;
    String[] currencies = new String[100];
    //List<String> currencies = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        imageView = findViewById(R.id.image);

        txt_amount = findViewById(R.id.amount_field);
        spinnerTo = findViewById(R.id.to_spinner);
        spinnerFrom = findViewById(R.id.from_spinner);
        convertBtn = findViewById(R.id.convBtn);
        textResult = findViewById(R.id.restxt2);
        mQueue = Volley.newRequestQueue(this);
        textTo = textFrom = "";
        currencies[0] = "EUR";
        //currencies = new String[]{"EUR", "EUR"};
        StringRequest stringRequest = new StringRequest(Request.Method.GET, VOLLEY_URL,
                new Response.Listener<String>() {
                    @Nullable
                    @Override
                    public void onResponse(String response) {
                        Json json = new Gson().fromJson(response, Json.class);
                        Log.i("RESPONSE", response);
                        int i = 0;
                        for (String cur: json.rates.keySet()){
                            if (i < 100){
                                currencies[i] = cur;
                                i++;
                            }
                        }
                        Arrays.sort(currencies);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textResult.setText("That didn't work! Please check your Internet connection");
                error.printStackTrace();
            }
        });
        mQueue.add(stringRequest);

        /*BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_converter);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.page_calculator):
                        startActivity(new Intent(getApplicationContext(), CalculatorActivity.class));
                        return true;
                    case (R.id.page_converter):
                        return true;
                }
                return false;
            }
        });*/

        ArrayAdapter<CharSequence> adapterFrom = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, currencies);
        //ArrayAdapter.createFromResource(this,
        //R.array.currencies, android.R.layout.simple_spinner_item);
        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapterFrom);
        spinnerFrom.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapterTo = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, currencies);
        //ArrayAdapter.createFromResource(this,
        //R.array.currencies, android.R.layout.simple_spinner_item);
        adapterTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTo.setAdapter(adapterTo);
        spinnerTo.setOnItemSelectedListener(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        //mQueue = Volley.newRequestQueue(this);
        convertBtn.setOnClickListener(new View.OnClickListener() {

            @Nullable
            @Override
            public void onClick(View v) {

                if (txt_amount.getText().toString().isEmpty()) {
                    createAlertDialog("Amount can't be empty", "Please enter Amount");
                    //} else if (spinnerFrom.getSelectedItemPosition() == 0) {
                } else if (textFrom.length() == 0) {
                    createAlertDialog("Base currency can't be empty", "Choose a currency from which you want to convert");
                    //} else if (spinnerTo.getSelectedItemPosition() == 0) {
                } else if (textTo.length() == 0) {
                    createAlertDialog("Convert currency can't be empty", "Choose a currency to which you want to convert");
                } else {
                    amount = Double.parseDouble(txt_amount.getText() + "");
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, VOLLEY_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Json json = new Gson().fromJson(response, Json.class);
                                    Log.i("RESPONSE", response);
                                    double a = 1 / json.rates.get(textFrom);
                                    final_toRate = json.rates.get(textTo);
                                    //final_result = json.getResult();
                                    if (textFrom.equals(textTo)){
                                        final_result = amount;
                                    }else {
                                        final_result = a * final_toRate * amount;
                                    }
                                    //NumberFormat formatter = new DecimalFormat("#0.00000");
                                    textResult.setText(amount + " " + textFrom + " = " + final_result + " " + textTo);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            textResult.setText("That didn't work! Please check your Internet connection");
                            error.printStackTrace();
                        }
                    });
                    mQueue.add(stringRequest);
                }
            }

        });
    }

    private void createAlertDialog(String title, String message) {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ConvertActivity.this);
        dlgAlert.setMessage(message);
        dlgAlert.setTitle(title);
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.from_spinner)
        {
            textFrom = parent.getItemAtPosition(position).toString();
        }
        else if(parent.getId() == R.id.to_spinner)
        {
            textTo = parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

}