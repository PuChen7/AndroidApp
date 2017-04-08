package com.example.pu.firstclaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private String display = "";
    private String operator;
    private String result = "";

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
        if (result != ""){
            clear();
            updateDisplay();
        }
        Button button = (Button) view;
        display +=button.getText();
        updateDisplay();
    }

    public void onClickOperator(View view){
        if (result != ""){
            display = result;
            result = "";
        }
        Button button = (Button) view;
        display += button.getText();
        operator = button.getText().toString();
        updateDisplay();
    }

    private void clear(){
        display = "";
        operator = "";
        result = "";
    }

    public void onClickClear(View view){
        clear();
        updateDisplay();
    }

    public void onClickDot(View view){

    }

    private double calculate(String num1, String num2, String operator){
        switch (operator){
            case "+":
                return Double.valueOf(num1) + Double.valueOf(num2);
            case "-":
                return Double.valueOf(num1) - Double.valueOf(num2);
            case "*":
                return Double.valueOf(num1) * Double.valueOf(num2);
            case "%":
                return Double.valueOf(num1) % Double.valueOf(num2);
            case "/":
                try{
                    return Double.valueOf(num1) / Double.valueOf(num2);
                } catch(Exception e){
                    Log.d("Calc", e.getMessage());
                }
            default:
                return -1;
        }
    }

    private void getResult(String[] components){

    }

    public void onClickEqual(View view) {
        String[] components = display.split(Pattern.quote(operator));
        if (components.length < 2){
            return;
        }
        result = String.valueOf(calculate(components[0], components[1], operator));
        screen.setText(display + "\n" + String.valueOf(result));
    }
}
