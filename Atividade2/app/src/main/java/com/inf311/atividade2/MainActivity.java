package com.inf311.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getValue(int id) {
        EditText editText = findViewById(id);
        return editText.getText().toString();
    }

    public void getRport(View view) {
        Bundle bundle = new Bundle();
        try {
            bundle.putString("name", getValue(R.id.name));
            bundle.putInt("age", Integer.parseInt(getValue(R.id.age)));
            bundle.putDouble("weight", Double.parseDouble((getValue(R.id.weight))));
            bundle.putDouble("height", Double.parseDouble((getValue(R.id.height))));
        } catch (Exception e) {
            return;
        }

        Intent it = new Intent(getBaseContext(), ReportActivity.class);
        it.putExtras(bundle);
        startActivity(it);
    }
}