package com.test.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// Main Activity (Simple Calculator)
public class MainActivity extends AppCompatActivity {

    boolean waitingSecond = false;
    float first, second;

    //1 = add, 2 = sub, 3 = mul, 4 = div
    int operation = 0;

    // Numbers
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;

    // Operations
    Button buttonAdd, buttonSub, buttonMul, buttonDiv;

    // Other
    Button buttonComma, buttonPerc, buttonPlusMinus, buttonEq, buttonClear, buttonDel;

    TextView numExpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lock orientation to portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        numExpr = findViewById(R.id.numExpr);
        numExpr.setText("");

        configure_buttonNumbers();
        configure_buttonOperations();
        configure_buttonOther();
    }

    public void configure_buttonNumbers() {

        // Button for number 0
        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNumber("0");
            }
        });

        // Button for number 1
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNumber("1");
            }
        });

        // Button for number 2
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNumber("2");
            }
        });

        // Button for number 3
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNumber("3");
            }
        });

        // Button for number 4
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNumber("4");
            }
        });

        // Button for number 5
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNumber("5");
            }
        });

        // Button for number 6
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNumber("6");
            }
        });

        // Button for number 7
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNumber("7");
            }
        });

        // Button for number 8
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNumber("8");
            }
        });

        // Button for number 9
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putNumber("9");
            }
        });
    }

    public void configure_buttonOperations() {

        // Button for addition
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond) {
                    // If an operator is clicked while a second number is expected, the user just wants to choose a different operator
                    // Only change the wanted operator
                    operation = 1;
                } else if (numExpr.getText().equals("")) {
                    // Empty input
                    message("Waiting for a number first");
                } else {
                    try {
                        if (operation != 0) {
                            // If the user wants to make a second calculation without pressing "=" first, press "=" programmatically to not lose the first calculation
                            // (for example user presses: 5 + 6 + 7)
                            buttonEq.performClick();
                        }
                        first = Float.parseFloat(numExpr.getText() + "");
                        operation = 1;

                        //Waiting for another number now
                        waitingSecond = true;
                    } catch (Exception e) {
                        // Exception to parseFloat if the input is not a valid float number
                        // (for example number "2..3")
                        message("Invalid number, try again");
                    }
                }
            }
        });

        // Button for subtraction
        buttonSub = findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond) {
                    operation = 2;
                } else if (numExpr.getText().equals("")) {
                    message("Waiting for a number first");
                } else {
                    try {
                        if (operation != 0) {
                            buttonEq.performClick();
                        }
                        first = Float.parseFloat(numExpr.getText() + "");
                        operation = 2;
                        waitingSecond = true;
                    } catch (Exception e) {
                        message("Invalid number, try again");
                    }
                }
            }
        });

        // Button for multiplication
        buttonMul = findViewById(R.id.buttonMul);
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond) {
                    operation = 3;
                } else if (numExpr.getText().equals("")) {
                    message("Waiting for a number first");
                } else {
                    try {
                        if (operation != 0) {
                            buttonEq.performClick();
                        }
                        first = Float.parseFloat(numExpr.getText() + "");
                        operation = 3;
                        waitingSecond = true;
                    } catch (Exception e) {
                        message("Invalid number, try again");
                    }
                }
            }
        });

        // Button for division
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (waitingSecond) {
                    operation = 4;
                } else if (numExpr.getText().equals("")) {
                    message("Waiting for a number first");
                } else {
                    try {
                        if (operation != 0) {
                            buttonEq.performClick();
                        }
                        first = Float.parseFloat(numExpr.getText() + "");
                        operation = 4;
                        waitingSecond = true;
                    } catch (Exception e) {
                        message("Invalid number, try again");
                    }
                }
            }
        });
    }

    public void configure_buttonOther() {

        // Button for comma
        buttonComma = findViewById(R.id.buttonComma);
        buttonComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("") || waitingSecond){
                    // If the input is empty, "." means "0."
                    // Ιf the second number of an operation is expected, clear the screen and start the new number as "0."
                    numExpr.setText("0");
                }
                numExpr.setText(numExpr.getText() + ".");
                waitingSecond = false;
            }
        });

        // Button for percentage (%)
        buttonPerc = findViewById(R.id.buttonPerc);
        buttonPerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("")) {
                    message("Waiting for a number first");
                } else {
                    try {
                        float temp = Float.parseFloat(numExpr.getText() + "");
                        numExpr.setText(temp / 100 + "");
                    } catch (Exception e){
                        message("Invalid number, try again");
                    }
                }
            }
        });

        // Button to change between positive / negative
        buttonPlusMinus = findViewById(R.id.buttonPlusMinus);
        buttonPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("")) {
                    message("Waiting for a number first");
                } else {
                    try {
                        float temp = Float.parseFloat(numExpr.getText() + "");
                        numExpr.setText((-1 * temp) + "");
                    } catch (Exception e){
                        message("Invalid number, try again");
                    }
                }
            }
        });

        // Button to calculate the result (=)
        buttonEq = findViewById(R.id.buttonEq);
        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numExpr.getText().equals("")) {
                    message("Waiting for a number first");
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
                        message("Invalid number, try again");
                    }
                }
            }
        });

        // Button to clear the input
        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset
                numExpr.setText("");
                operation = 0;
                waitingSecond = false;
            }
        });

        // Button to delete the last character of the input
        buttonDel = findViewById(R.id.buttonDel);
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

    // Display number on the screen
    public void putNumber(String number){

        if (waitingSecond) {
            // Ιf the second number of an operation is expected, clear the screen to start the new number
            numExpr.setText("");
            // Stop waiting for the second number
            waitingSecond = false;
        }
        numExpr.setText(numExpr.getText() + number);
    }

    // Alert message
    public void message (String message){

        int duration = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();
        Toast.makeText(context, message, duration).show();
    }
}