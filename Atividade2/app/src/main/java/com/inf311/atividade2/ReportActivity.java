package com.inf311.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

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
}