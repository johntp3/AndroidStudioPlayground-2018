package com.example.john.war;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    //card structure: H 2-A, C 2-A, S 2-A, D 2-A
    int[] regularCards = {2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,
            8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14};
    int[] drawableRes = {R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6,
            R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10, R.drawable.hj, R.drawable.hq,
            R.drawable.hk, R.drawable.ha, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10, R.drawable.cj,
            R.drawable.cq, R.drawable.ck, R.drawable.ca, R.drawable.s2, R.drawable.s3, R.drawable.s4,
            R.drawable.s5, R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10,
            R.drawable.sj, R.drawable.sq, R.drawable.sk, R.drawable.sa, R.drawable.d2, R.drawable.d3,
            R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9,
            R.drawable.d10, R.drawable.dj, R.drawable.dq, R.drawable.dk, R.drawable.da};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
