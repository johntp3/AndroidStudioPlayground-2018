package com.example.john.war;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    //card structure: H 2-A, C 2-A, S 2-A, D 2-A
    int[] regularCards = {2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,
            8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14};
    int[] drawableres = {R.drawable.H2, };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
