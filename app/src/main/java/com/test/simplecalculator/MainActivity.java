package com.test.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

// Main Activity
public class MainActivity extends AppCompatActivity {

    int duration = Toast.LENGTH_SHORT;

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonMul,
            buttonDiv, buttonPerc, buttonPlusMinus, buttonClear, buttonEq, buttonDel, buttonComma;

    TextView numExpr;

    float first, second;

    boolean add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonPerc = (Button) findViewById(R.id.buttonPerc);
        buttonPlusMinus = (Button) findViewById(R.id.buttonPlusMinus);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonEq = (Button) findViewById(R.id.buttonEq);
        buttonDel = (Button) findViewById(R.id.buttonDel);
        buttonComma = (Button) findViewById(R.id.buttonComma);
        numExpr = (TextView) findViewById(R.id.numExpr);
        numExpr.setText("");

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText(numExpr.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText(numExpr.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText(numExpr.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText(numExpr.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText(numExpr.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText(numExpr.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText(numExpr.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText(numExpr.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText(numExpr.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText(numExpr.getText() + "9");
            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        first = Float.parseFloat(numExpr.getText() + "");
                        add = true;
                        numExpr.setText("");
                    } catch (Exception e){
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Invalid number, try again", duration).show();
                    }
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        first = Float.parseFloat(numExpr.getText() + "");
                        sub = true;
                        numExpr.setText("");
                    } catch (Exception e){
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Invalid number, try again", duration).show();
                    }
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        first = Float.parseFloat(numExpr.getText() + "");
                        mul = true;
                        numExpr.setText("");
                    } catch (Exception e){
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Invalid number, try again", duration).show();
                    }
                }
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        first = Float.parseFloat(numExpr.getText() + "");
                        div = true;
                        numExpr.setText("");
                    } catch (Exception e){
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Invalid number, try again", duration).show();
                    }
                }
            }
        });

        buttonPerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        first = Float.parseFloat(numExpr.getText() + "");
                        numExpr.setText(first / 100 + "");
                    } catch (Exception e){
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Invalid number, try again", duration).show();
                    }
                }
            }
        });

        buttonPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        first = Float.parseFloat(numExpr.getText() + "");
                        numExpr.setText((-1 * first) + "");
                    } catch (Exception e){
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Invalid number, try again", duration).show();
                    }
                }
            }
        });

        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        second = Float.parseFloat(numExpr.getText() + "");
                        if (add == true) {
                            numExpr.setText(first + second + "");
                            add = false;
                        }

                        if (sub == true) {
                            numExpr.setText(first - second + "");
                            sub = false;
                        }

                        if (mul == true) {
                            numExpr.setText(first * second + "");
                            mul = false;
                        }

                        if (div == true) {
                            numExpr.setText(first / second + "");
                            div = false;
                        }
                    } catch (Exception e){
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Invalid number, try again", duration).show();
                    }
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numExpr.setText("");
            }
        });

        buttonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("")){
                    numExpr.setText("0");
                }
                numExpr.setText(numExpr.getText() + ".");
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence cur = numExpr.getText();
                if (cur.length() > 0){
                    numExpr.setText(cur.subSequence(0, cur.length() - 1));
                }
            }
        });
    }
}