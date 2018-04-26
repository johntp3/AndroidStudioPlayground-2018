package com.example.john.war;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    //card structure: H 2-A, C 2-A, S 2-A, D 2-A
    int[] regularCards = {2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,5,6,7,
            8,9,10,11,12,13,14,2,3,4,5,6,7,8,9,10,11,12,13,14};
    int[] drawableRes = {R.drawable.H2, R.drawable.H3, R.drawable.H4, R.drawable.H5, R.drawable.H6,
            R.drawable.H7, R.drawable.H8, R.drawable.H9, R.drawable.H10, R.drawable.HJ, R.drawable.HQ,
            R.drawable.HK, R.drawable.HA, R.drawable.C2, R.drawable.C3, R.drawable.C4, R.drawable.C5,
            R.drawable.C6, R.drawable.C7, R.drawable.C8, R.drawable.C9, R.drawable.C10, R.drawable.CJ,
            R.drawable.CQ, R.drawable.CK, R.drawable.CA, R.drawable.S2, R.drawable.S3, R.drawable.S4,
            R.drawable.S5, R.drawable.S6, R.drawable.S7, R.drawable.S8, R.drawable.S9, R.drawable.S10,
            R.drawable.SJ, R.drawable.SQ, R.drawable.SK, R.drawable.SA, R.drawable.D2, R.drawable.D3,
            R.drawable.D4, R.drawable.D5, R.drawable.D6, R.drawable.D7, R.drawable.D8, R.drawable.D9,
            R.drawable.D10, R.drawable.DJ, R.drawable.DQ, R.drawable.DK, R.drawable.DA};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
