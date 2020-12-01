package com.inf311.atividade4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getStringFromView(int id) {
        EditText edt = findViewById(id);
        return edt.getText().toString();
    }

    private double getDouble(int id) {
        return Double.parseDouble(getStringFromView(id));
    }

    private int getInt(int id) {
        return Integer.parseInt(getStringFromView(id));
    }

    public void onClick(View v) {
        double peso = getDouble(R.id.editTextNumber);
        String sexo = getStringFromView(R.id.editTextNumber2);
        int copos = getInt(R.id.editTextNumber3);
        String jejum = getStringFromView(R.id.editTextNumber4);

        Bundle params = new Bundle();
        params.putDouble("peso", peso);
        params.putString("sexo", sexo);
        params.putInt("copos", copos);
        params.putString("jejum", jejum);

        Intent it = new Intent(this, MainActivity2.class);
        it.putExtras(params);

        startActivityForResult(it, 1);
    }

    @Override
    protected void onActivityResult(int codigoRequisicao, int codigoResultado, Intent it) {
//        super.onActivityResult(codigoRequisicao, codigoResultado, it);
        double taxa = it.getDoubleExtra("taxa", 0);
        String classificacao;
        if (taxa > 0.2) {
            classificacao = "Pessoa Alcoolizada";
        } else {
            classificacao = "Pessoa NÂO Alcoolizada";
        }
        Toast.makeText(this, "Taxa de Alcoolemia: " + taxa + "\nClassificacão: " + classificacao, Toast.LENGTH_LONG).show();
    }
}
