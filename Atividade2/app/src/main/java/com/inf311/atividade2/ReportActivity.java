package com.inf311.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Log.i("B", "onStart: Report");

        Intent it = getIntent();
        Bundle params = it.getExtras();

        assert params != null;
        setText(R.id.nameReport, params.getString("name"));
        setText(R.id.ageReport, String.valueOf(params.getInt("age")));
        double height = params.getDouble("height");
        double weight = params.getDouble("weight");
        double imc = getIMC(weight, height);
        setText(R.id.weightReport, String.valueOf(weight));
        setText(R.id.heightReport, String.valueOf(height));
        setText(R.id.imc, String.valueOf(imc));
        setText(R.id.classify, getClassify(imc));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("B", "onStart: Report");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("B", "onResume: Report");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("B", "onRestart: Report");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("B", "onPause: Report");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("B", "onStop: Report");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("B", "onDestroy: Report");
    }

    private String getClassify(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 25) {
            return "Saudável";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 35) {
            return "Obesidade Grau I";
        } else if (imc >= 35 && imc < 40) {
            return "Obesidade Grau II (Severa)";
        } else {
            return "Obesidade Grau III (Mórbida)";
        }
    }

    private double getIMC(double weight, double height) {
        return (weight / (height * height));
    }

    private void setText(int id, String text) {
        TextView view = findViewById(id);
        view.setText(text);
    }

    public void newCalc(View view) {
        finish();
    }
}