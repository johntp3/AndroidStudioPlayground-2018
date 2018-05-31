package com.example.john.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Dot, Negative, division, multiplication, subtraction, addition, Enter, clear, backspace;
    TextView computationLine, result;
    final char DIVISION = '/';
    final char MULTIPLICATION = '*';
    final char SUBTRACTION = '-';
    final char ADDITION = '+';
    final char ENTER = '0';
    char ACTION;
    double val1 = Double.NaN;
    double val2;
    boolean operatorJustPressed = false, specialCharJustPressed = false;
    int operatorPressed = 0;
    String name, resultName, endName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setting up all the buttons
        Zero = findViewById(R.id.Zero); One = findViewById(R.id.One); Two = findViewById(R.id.Two); Three = findViewById(R.id.Three); Four = findViewById(R.id.Four);
        Five = findViewById(R.id.Five); Six = findViewById(R.id.Six); Seven = findViewById(R.id.Seven); Eight = findViewById(R.id.Eight); Nine = findViewById(R.id.Nine);
        Dot = findViewById(R.id.Dot); Negative = findViewById(R.id.Negative); division = findViewById(R.id.division); multiplication = findViewById(R.id.multiplication);
        subtraction = findViewById(R.id.subtraction); addition = findViewById(R.id.addition); Enter = findViewById(R.id.Enter); clear = findViewById(R.id.clear);
        backspace = findViewById(R.id.backspace);
        //linking TextView to MainActivity
        computationLine = findViewById(R.id.computationLine); result = findViewById(R.id.result);
        //here is where the values will be stored for computation later on

        Zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "0");
                operatorJustPressed = false;
                specialCharJustPressed = false;
            }
        });

        One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "1");
                operatorJustPressed = false;
                specialCharJustPressed = false;
            }
        });

        Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "2");
                operatorJustPressed = false;
                specialCharJustPressed = false;
            }
        });

        Three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "3");
                operatorJustPressed = false;
                specialCharJustPressed = false;
            }
        });

        Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "4");
                operatorJustPressed = false;
                specialCharJustPressed = false;
            }
        });

        Five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "5");
                operatorJustPressed = false;
                specialCharJustPressed = false;
            }
        });

        Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "6");
                operatorJustPressed = false;
                specialCharJustPressed = false;
            }
        });

        Seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "7");
                operatorJustPressed = false;
                specialCharJustPressed = false;
            }
        });

        Eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "8");
                operatorJustPressed = false;
                specialCharJustPressed = false;
            }
        });

        Nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "9");
                operatorJustPressed = false;
                specialCharJustPressed = false;
            }
        });

        Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + ".");
                operatorJustPressed = false;
                specialCharJustPressed = true;
            }
        });

        Negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computationLine.setText(computationLine.getText().toString() + "-");
                operatorJustPressed = false;
                specialCharJustPressed = true;
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(computationLine.getText().length() > 0) {
                    compute();
                    ACTION = DIVISION;
                    result.setText(String.valueOf(val1) + " / ");
                    operatorJustPressed = true;
                    operatorPressed++;
                } else if (result.getText().length() > 0) {
                    ACTION = DIVISION;
                    val1 = Double.parseDouble(result.getText().toString().substring(result.getText().toString().lastIndexOf(" ") + 1));
                    result.setText(result.getText().toString().substring(result.getText().toString().lastIndexOf(" ") + 1) + " / ");
                    operatorPressed++;
                } else {
                    Toast.makeText(MainActivity.this, "Please enter something before the operator", Toast.LENGTH_SHORT).show();
                }
                computationLine.setText(null);
                specialCharJustPressed = false;
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(computationLine.getText().length() > 0) {
                    compute();
                    ACTION = MULTIPLICATION;
                    result.setText(String.valueOf(val1) + " * ");
                    operatorJustPressed = true;
                    operatorPressed++;
                } else if (result.getText().length() > 0) {
                    ACTION = MULTIPLICATION;
                    val1 = Double.parseDouble(result.getText().toString().substring(result.getText().toString().lastIndexOf(" ") + 1));
                    result.setText(result.getText().toString().substring(result.getText().toString().lastIndexOf(" ") + 1) + " * ");
                    operatorPressed++;
                } else {
                    Toast.makeText(MainActivity.this, "Please enter something before the operator", Toast.LENGTH_SHORT).show();
                }
                computationLine.setText(null);
                specialCharJustPressed = false;
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(computationLine.getText().length() > 0) {
                    compute();
                    ACTION = SUBTRACTION;
                    result.setText(String.valueOf(val1) + " - ");
                    operatorJustPressed = true;
                    operatorPressed++;
                } else if (result.getText().length() > 0) {
                    ACTION = SUBTRACTION;
                    val1 = Double.parseDouble(result.getText().toString().substring(result.getText().toString().lastIndexOf(" ") + 1));
                    result.setText(result.getText().toString().substring(result.getText().toString().lastIndexOf(" ") + 1) + " - ");
                    operatorPressed++;
                } else {
                    Toast.makeText(MainActivity.this, "Please enter something before the operator", Toast.LENGTH_SHORT).show();
                }
                computationLine.setText(null);
                specialCharJustPressed = false;

            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(computationLine.getText().length() > 0) {
                    compute();
                    ACTION = ADDITION;
                    result.setText(String.valueOf(val1) + " + ");
                    operatorJustPressed = true;
                    operatorPressed++;
                } else if (result.getText().length() > 0) {
                    ACTION = ADDITION;
                    val1 = Double.parseDouble(result.getText().toString().substring(result.getText().toString().lastIndexOf(" ") + 1));
                    result.setText(result.getText().toString().substring(result.getText().toString().lastIndexOf(" ") + 1) + " + ");
                    operatorPressed++;
                } else {
                    Toast.makeText(MainActivity.this, "Please enter something before the operator", Toast.LENGTH_SHORT).show();
                }
                computationLine.setText(null);
                specialCharJustPressed = false;
            }
        });

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (specialCharJustPressed) {
                    Toast.makeText(MainActivity.this, "Please enter something after the special character.", Toast.LENGTH_SHORT).show();
                } else if (operatorJustPressed) {
                    Toast.makeText(MainActivity.this, "Please enter something after the operator.", Toast.LENGTH_SHORT).show();
                } else if (!operatorJustPressed && operatorPressed > 0) {
                    compute();
                    ACTION = ENTER;
                    result.setText(result.getText().toString() + String.valueOf(val2) + " = " + String.valueOf(val1));
                    computationLine.setText(null);
                    val1 = Double.NaN;
                    operatorJustPressed = false;
                    operatorPressed = 0;
                } else {
                    if(computationLine.getText().length() == 0) {
                        result.setText("");
                    } else {
                        result.setText(computationLine.getText().toString() + " = " + computationLine.getText().toString());
                    }
                    computationLine.setText(null);
                    val1 = Double.NaN;
                    operatorJustPressed = false;
                    operatorPressed = 0;
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(null);
                computationLine.setText(null);
                val1 = Double.NaN;
                operatorJustPressed = false;
                operatorPressed = 0;
                specialCharJustPressed = false;
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                specialCharJustPressed = false;
                operatorJustPressed = false;
                name = computationLine.getText().toString();
                if(computationLine.getText().length() > 0) {
                    computationLine.setText(name.substring(0, name.length()-1));

                    endName = computationLine.getText().toString();
                    resultName = result.getText().toString();
                    if(computationLine.getText().length() > 0) {
                        if(endName.substring(endName.length()-1).equals(".") || endName.substring(endName.length()-1).equals("-")) {
                            specialCharJustPressed = true;
                        }
                    } else {
                        if(resultName.contains("/") || resultName.contains("*") || resultName.contains("-") || resultName.contains("+")) {
                            operatorJustPressed = true;
                        }
                    }

                } else {
                    result.setText(null);
                    computationLine.setText(null);
                    val1 = Double.NaN;
                    operatorJustPressed = false;
                    operatorPressed = 0;
                    specialCharJustPressed = false;
                }
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
