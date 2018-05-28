package com.example.john.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Dot, Negative, division, multiplication, subtraction, addition, Enter;
    TextView computationLine, result;
    final char DIVISION = '/';
    final char MULTIPLICATION = '*';
    final char SUBTRACTION = '-';
    final char ADDITION = '+';
    final char ENTER = '0';
    char ACTION;
    double val1 = Double.NaN;
    double val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setting up all the buttons
        Zero = findViewById(R.id.Zero); One = findViewById(R.id.One); Two = findViewById(R.id.Two); Three = findViewById(R.id.Three); Four = findViewById(R.id.Four);
        Five = findViewById(R.id.Five); Six = findViewById(R.id.Six); Seven = findViewById(R.id.Seven); Eight = findViewById(R.id.Eight); Nine = findViewById(R.id.Nine);
        Dot = findViewById(R.id.Dot); Negative = findViewById(R.id.Negative); division = findViewById(R.id.division); multiplication = findViewById(R.id.multiplication);
        subtraction = findViewById(R.id.subtraction); addition = findViewById(R.id.addition); Enter = findViewById(R.id.Enter);
        //linking TextView to MainActivity
        computationLine = findViewById(R.id.computationLine); result = findViewById(R.id.result);
        //here is where the values will be stored for computation later on

        Zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "0");
            }
        });

        One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "1");
            }
        });

        Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "2");
            }
        });

        Three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "3");
            }
        });

        Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "4");
            }
        });

        Five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "5");
            }
        });

        Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "6");
            }
        });

        Seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "7");
            }
        });

        Eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "8");
            }
        });

        Nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "9");
            }
        });

        Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + ".");
            }
        });

        Negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "-");
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + " / ");
                computationLine.setText(null);
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + " * ");
                computationLine.setText(null);
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(val1) + " - ");
                computationLine.setText(null);

            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1) + " + ");
                computationLine.setText(null);
            }
        });

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ENTER;
                result.setText(result.getText().toString() + String.valueOf(val2) + " = " + String.valueOf(val1));
                computationLine.setText(null);
                val1 = Double.NaN;
            }
        });
    }

    private void compute() {
        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(computationLine.getText().toString());

            switch (ACTION) {
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1*val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case ENTER:
                    break;
            }
        } else {
            val1 = Double.parseDouble(computationLine.getText().toString());
        }
    }
}
