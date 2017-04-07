package com.example.pu.firstclaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // set up buttons
    private Button one, two, three, four, five, six, seven, eight, nine, zero,
            add, subtract, divide, multiply,
            clear, mod, dot, double_zero, equal;

    private TextView screen;
    private String display = "";
    private String operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView)findViewById(R.id.textView);
        screen.setText(display);
    }

    private void updateDisplay(){
        screen.setText(display);
    }

    public void onClickNumber(View view){
        Button button = (Button) view;
        display = display + button.getText();
        updateDisplay();
    }

    public void onClickOperator(View view){
        Button button = (Button) view;
        display = display + button.getText();
        operator = button.getText().toString();
        updateDisplay();
    }

    private void clear(){
        display = "";
        operator = "";
        updateDisplay();
    }

    public void onClickEqual(View view){

    }

    public void onClickClear(View view){
        clear();
        updateDisplay();
    }

    public void onClickDot(View view){

    }
}
