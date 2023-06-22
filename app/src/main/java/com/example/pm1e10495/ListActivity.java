package com.example.pm1e10495;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pm1e10495.Configuracion.SQLiteConexion;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listpersonas;
    ArrayList <Personas> lista;
    ArrayList<String> ArregloPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
}