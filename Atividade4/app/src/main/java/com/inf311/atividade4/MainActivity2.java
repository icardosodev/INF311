package com.inf311.atividade4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    public void onClick(View v) {
        Log.d("onClick", "HERE");
        Intent it = getIntent();
        double coeficiente = 0;
        if (it.getStringExtra("jejum").equals("s")) {
            if (it.getStringExtra("sexo").equals("m")) {
                coeficiente = 0.7;
            } else if (it.getStringExtra("sexo").equals("f")) {
                coeficiente = 0.6;
            }
        } else if (it.getStringExtra("jejum").equals("n")) {
            coeficiente = 1.1;
        }
        double alcoolConsumido = it.getIntExtra("copos", 0) * 4.8;

        double peso = it.getDoubleExtra("peso", 0);
        double taxa = alcoolConsumido / peso * coeficiente;

        it.putExtra("taxa", taxa);

        Log.d("TAXA", String.valueOf(taxa));

        setResult(1, it);

        finish();
    }
}