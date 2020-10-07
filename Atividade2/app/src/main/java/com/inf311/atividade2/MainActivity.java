package com.inf311.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("B", "onCreate: Main");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("B", "onStart: Main");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("B", "onResume: Main");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("B", "onRestart: Main");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("B", "onPause: Main");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("B", "onStop: Main");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("B", "onDestroy: Main");
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