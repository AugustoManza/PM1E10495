package com.example.pm1e10495;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner Lista;

    EditText nombre, telefono, notas;
    Button btnsalvar, btnvercontacto;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.txtnombre);
        telefono = findViewById(R.id.txttelefono);
        notas = findViewById(R.id.txtnota);


        btnsalvar = (Button) findViewById(R.id.btnsalvar);
        btnvercontacto = (Button) findViewById(R.id.btnvercontactos);




        Lista=(Spinner) findViewById(R.id.selectpais);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.list, android.R.layout.simple_list_item_1);
        Lista.setAdapter(adapter);







    }
}