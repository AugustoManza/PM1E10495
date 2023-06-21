package com.example.pm1e10495;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lista=(Spinner) findViewById(R.id.selectpais);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.list, android.R.layout.simple_list_item_1);
        Lista.setAdapter(adapter);
    }
}