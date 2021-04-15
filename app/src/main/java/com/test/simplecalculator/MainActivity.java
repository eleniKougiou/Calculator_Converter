package com.test.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// Main Activity
public class MainActivity extends AppCompatActivity {

    boolean waitingSecond;
    float first, second;
    int duration = Toast.LENGTH_SHORT;
    //1 = add, 2 = sub, 3 = mul, 4 = div
    int operation;

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    Button buttonPerc, buttonPlusMinus, buttonClear, buttonEq, buttonDel, buttonComma;
    TextView numExpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configure_buttonNumbers();
    }

    public void configure_buttonNumbers() {
        // Button 0
        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    numExpr.setText("");
                    waitingSecond = false;
                }
                numExpr.setText(numExpr.getText() + "0");
            }
        });

        // Button 1
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    numExpr.setText("");
                    waitingSecond = false;
                }
                numExpr.setText(numExpr.getText() + "1");
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    numExpr.setText("");
                    waitingSecond = false;
                }
                numExpr.setText(numExpr.getText() + "2");
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    numExpr.setText("");
                    waitingSecond = false;
                }
                numExpr.setText(numExpr.getText() + "3");
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    numExpr.setText("");
                    waitingSecond = false;
                }
                numExpr.setText(numExpr.getText() + "4");
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    numExpr.setText("");
                    waitingSecond = false;
                }
                numExpr.setText(numExpr.getText() + "5");
            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    numExpr.setText("");
                    waitingSecond = false;
                }
                numExpr.setText(numExpr.getText() + "6");
            }
        });

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    numExpr.setText("");
                    waitingSecond = false;
                }
                numExpr.setText(numExpr.getText() + "7");
            }
        });

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    numExpr.setText("");
                    waitingSecond = false;
                }
                numExpr.setText(numExpr.getText() + "8");
            }
        });

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    numExpr.setText("");
                    waitingSecond = false;
                }
                numExpr.setText(numExpr.getText() + "9");
            }
        });
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
        operation = 0;
        waitingSecond = false;


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond){
                    operation = 1;
                } else if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        if(operation != 0){
                            buttonEq.performClick();
                        }
                        first = Float.parseFloat(numExpr.getText() + "");
                        operation = 1;
                        waitingSecond = true;
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
                if (waitingSecond){
                    operation = 2;
                } else if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        if(operation != 0){
                            buttonEq.performClick();
                        }
                        first = Float.parseFloat(numExpr.getText() + "");
                        operation = 2;
                        waitingSecond = true;
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
                if (waitingSecond){
                    operation = 3;
                } else if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        if(operation != 0){
                            buttonEq.performClick();
                        }
                        first = Float.parseFloat(numExpr.getText() + "");
                        operation = 3;
                        waitingSecond = true;
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
                if (waitingSecond){
                    operation = 4;
                } else if (numExpr.getText().equals("")) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Waiting for a number first", duration).show();
                } else {
                    try {
                        if(operation != 0){
                            buttonEq.performClick();
                        }
                        first = Float.parseFloat(numExpr.getText() + "");
                        operation = 4;
                        waitingSecond = true;
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
                        numExpr.setText(Float.parseFloat(numExpr.getText() + "") / 100 + "");
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
                        numExpr.setText((-1 * Float.parseFloat(numExpr.getText() + "")) + "");
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
                        if (operation == 1) {
                            numExpr.setText(first + second + "");
                        }
                        if (operation == 2) {
                            numExpr.setText(first - second + "");
                        }
                        if (operation == 3) {
                            numExpr.setText(first * second + "");
                        }
                        if (operation == 4) {
                            numExpr.setText(first / second + "");
                        }
                        operation = 0;
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
                operation = 0;
                waitingSecond = false;
            }
        });

        buttonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("") || waitingSecond){
                    numExpr.setText("0");
                }
                numExpr.setText(numExpr.getText() + ".");
                waitingSecond = false;
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