package com.example.pu.firstclaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // two input number
    private double numbOne, numTwo;

    // operators
    private static final char ADDITION = '+';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char SUBTRACTOIN = '-';
    
}
