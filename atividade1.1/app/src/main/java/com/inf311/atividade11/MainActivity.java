package com.inf311.atividade11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void showExpression(String exp) {
        TextView view = findViewById(R.id.textView);
        view.setText(exp);
    }

    private double calculate(String exp) {
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '+') {
                double a, b;
                a = Double.parseDouble(exp.split("[+]")[0]);
//                b = Double.parseDouble(exp.split("[+]")[1]);
            }
        }
        return 0;
    }

    private String removeLastChar(String exp) {
        return exp.substring(0, exp.length() -1);
    }

    private String removeSymbol(String exp){

        String last = exp.substring(exp.length() -1);
        if (last.equals("+") || last.equals("-") || last.equals("X") || last.equals("/")) {
            return removeLastChar(exp);
        }
        return exp;
    }

    public void handleButtonClick(View view) {
        TextView text = findViewById(R.id.textView);
        String exp = (String) text.getText();
        int id = view.getId();
        switch (id) {
            case R.id.button:
                exp = removeLastChar(exp);
                break;
            case R.id.button2:
                exp = "";
                break;
            case R.id.button3:
                double res = calculate(exp);
                exp = String.format(Locale.US,"%f", res);
                break;
            case R.id.button4:
                if (exp.length() < 1) {
                    break;
                }
                exp = removeSymbol(exp);
                exp += "+";
                break;
            case R.id.button5:
                if (exp.length() < 1) {
                    break;
                }
                exp = removeSymbol(exp);
                exp += "-";
                break;
            case R.id.button6:
                if (exp.length() < 1) {
                    break;
                }
                exp = removeSymbol(exp);
                exp += "X";
                break;
            case R.id.button7:
                exp += "9";
                break;
            case R.id.button8:
                if (exp.length() < 1) {
                    break;
                }
                exp += ".";
                break;
            case R.id.button9:
                if (exp.length() < 1) {
                    break;
                }
                exp = removeSymbol(exp);
                exp += "/";
                break;
            case R.id.button10:
                exp += "6";
                break;
            case R.id.button11:
                exp += "7";
                break;
            case R.id.button12:
                exp += "8";
                break;
            case R.id.button13:
                exp += "3";
                break;
            case R.id.button14:
                exp += "4";
                break;
            case R.id.button15:
                exp += "5";
                break;
            case R.id.button16:
                exp += "0";
                break;
            case R.id.button17:
                exp += "1";
                break;
            case R.id.button18:
                exp += "2";
                break;
        }
        showExpression(exp);
    }
}