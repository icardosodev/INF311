package com.INF311.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sum(View view) {
        double valor1, valor2, res;

        valor1 = getValor(R.id.valor1);
        valor2 = getValor(R.id.valor2);

        res = valor1 + valor2;

        setText(res);

    }

    public void subtract(View view) {
        double valor1, valor2;

        valor1 = getValor(R.id.valor1);
        valor2 = getValor(R.id.valor2);

        setText(valor1 - valor2);
    }

    public void multiply(View view) {
        double valor1, valor2;

        valor1 = getValor(R.id.valor1);
        valor2 = getValor(R.id.valor2);

        setText(valor1 * valor2);
    }

    public void divide(View view) {
        double valor1, valor2;

        valor1 = getValor(R.id.valor1);
        valor2 = getValor(R.id.valor2);

        setText(valor1 / valor2);
    }

    private double getValor(int id) {
        EditText editText  = findViewById(id);
        return Double.parseDouble(editText.getText().toString());
    }

}