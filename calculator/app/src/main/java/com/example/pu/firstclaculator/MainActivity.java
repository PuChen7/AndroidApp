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

    private boolean isOperator(char opChar) {
        switch (opChar){
            case '+':
            case '-':
            case '*':
            case '/': return true;
            default: return false;
        }
    }

    public void onClickOperator(View view){
        if (display == ""){return;}

        Button button = (Button) view;

        if (result != ""){
            String tmpDisplay = result;
            clear();
            display = tmpDisplay;
        }

        if (operator != "") {
            Log.d("Calcx", ""+display.charAt(display.length()-1));
            if (isOperator(display.charAt(display.length()-1))){
                display = display.replace(display.charAt(display.length()-1), button.getText().charAt(0));
                updateDisplay();
                return;
            } else {
                getResult();
                display = result;
                result = "";
            }
            operator = button.getText().toString();
        }

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

    private boolean getResult(){
        if (operator == ""){
            return false;
        }
        String[] components = display.split(Pattern.quote(operator));
        if (components.length < 2){
            return false;
        }
        result = String.valueOf(calculate(components[0], components[1], operator));
        return true;
    }

    public void onClickEqual(View view) {
        if (display == ""){return;}
        if (!getResult()){return;}
        screen.setText(display + "\n" + String.valueOf(result));
    }
}
