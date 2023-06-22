package com.example.pm1e10495;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pm1e10495.Configuracion.SQLiteConexion;
import com.example.pm1e10495.Configuracion.Transacciones;

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

    private void AddContacto()
    {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase,null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombre, nombre.getText().toString());
        valores.put(Transacciones.pais, Lista.getSelectedItem().toString());
        valores.put(Transacciones.telefono, telefono.getText().toString());
        valores.put(Transacciones.nota, notas.getText().toString());


        Long result = db.insert(Transacciones.tablaContactos, Transacciones.id, valores);
        Toast.makeText(getApplicationContext(), "Registro ingresado : " + result.toString(),Toast.LENGTH_LONG ).show();

        db.close();

        CleanScreen();

    }


    private void CleanScreen()
    {
        nombre.setText("");
        telefono.setText("");
        notas.setText("");
        Lista.setSelection(0);
    }
}