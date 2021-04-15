package com.test.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Html;
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

// Convert Activity (Currency Converter)
public class ConvertActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    double amount, final_toRate, final_result;
    int idxFrom, idxTo;
    String textTo, textFrom;
    String url = "http://data.fixer.io/api/latest?access_key=038674f3a04897967685ce8bc9114497";
    String[] currencies = new String[101];

    EditText txt_amount;
    Spinner spinnerTo, spinnerFrom;
    TextView textResult;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        // Lock orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initialize();
        configure_buttonConvert();
        configure_buttonChange();

    }

    // Initialization of necessary variables
    public void initialize(){

        txt_amount = findViewById(R.id.amountValue);
        spinnerTo = findViewById(R.id.toValue);
        spinnerFrom = findViewById(R.id.fromValue);
        textResult = findViewById(R.id.conversionResult);
        queue = Volley.newRequestQueue(this);
        textTo = textFrom = "";
        currencies[0] = "";

        // Send request to fixer to learn the available currencies
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Json json = new Gson().fromJson(response, Json.class);
                        Log.i("RESPONSE", response);
                        int i = 1;
                        for (String cur: json.rates.keySet()){
                            // Save max 100 currencies
                            if (i < 101){
                                currencies[i] = cur;
                                i++;
                            }
                        }
                        Arrays.sort(currencies);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                message("Error");
                error.printStackTrace();
            }
        });
        queue.add(stringRequest);


        ArrayAdapter<CharSequence> adapterFrom = new ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies);
        adapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Spinner with currencies to change from
        spinnerFrom.setAdapter(adapterFrom);
        spinnerFrom.setOnItemSelectedListener(this);

        // Spinner with currencies to change to
        spinnerTo.setAdapter(adapterFrom);
        spinnerTo.setOnItemSelectedListener(this);
    }


    public void configure_buttonConvert(){

        // Button for conversion
        Button buttonConvert = findViewById(R.id.buttonConvert);
        buttonConvert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (txt_amount.getText().toString().isEmpty()) {
                    // Empty amount
                    message("Enter the amount you would like to convert");
                } else if (textFrom.length() == 0) {
                    // Empty FROM field
                    message("Choose the currency you would like to convert FROM");
                } else if (textTo.length() == 0) {
                    // Empty TO field
                    message("Choose the currency you would like to convert TO");
                } else {
                    amount = Double.parseDouble(txt_amount.getText() + "");

                    // Send request to fixer to learn the latest exchange rate data
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Json json = new Gson().fromJson(response, Json.class);
                                    Log.i("RESPONSE", response);

                                    // Possibility to convert between any two currencies, using EUR data
                                    // (fixer free plan offers exchange rate data related only to EUR)
                                    double a = 1 / json.rates.get(textFrom);
                                    final_toRate = json.rates.get(textTo);

                                    // Calculate result
                                    if (textFrom.equals(textTo)){
                                        // No need to change
                                        final_result = amount;
                                    }else {
                                        final_result = a * final_toRate * amount;
                                    }

                                    // Round to 3 decimals
                                    final_result = (double)Math.round(final_result * 1000d) / 1000d;

                                    // Display result
                                    String strResult = amount + " " + textFrom + " = <b>" + final_result + "</b> " + textTo;
                                    textResult.setText(Html.fromHtml(strResult));
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            message("Error");
                            error.printStackTrace();
                        }
                    });
                    queue.add(stringRequest);
                }
            }
        });
    }

    // Button to switch FROM and TO values
    public void configure_buttonChange(){

        ImageView buttonChange = findViewById(R.id.buttonChange);
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerFrom.setSelection(idxTo);
                spinnerTo.setSelection(idxFrom);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.fromValue) {
            // FROM spinner
            // Save the wanted currency and the position in case of switch currencies request
            textFrom = parent.getItemAtPosition(position).toString();
            idxFrom = position;
        } else if(parent.getId() == R.id.toValue) {
            // TO spinner
            textTo = parent.getItemAtPosition(position).toString();
            idxTo = position;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // Alert message
    public void message (String message){

        int duration = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();
        Toast.makeText(context, message, duration).show();
    }

}