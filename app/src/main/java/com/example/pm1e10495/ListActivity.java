package com.example.pm1e10495;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pm1e10495.Configuracion.SQLiteConexion;
import com.example.pm1e10495.Configuracion.Transacciones;
import com.example.pm1e10495.Models.Contactos;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listContactos;
    ArrayList <Contactos> lista;
    ArrayList<String> ArregloContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listContactos = (ListView) findViewById(R.id.listaContactos);

        ObtenerTabla();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloContactos);
        listContactos.setAdapter(adp);

        listContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Obtener el elemento seleccionado en la lista
                String selectedItem = (String) adapterView.getItemAtPosition(i);

                // Realizar alguna acción con el elemento seleccionado
                Toast.makeText(getApplicationContext(), "Seleccionaste: " + selectedItem, Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void ObtenerTabla()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Contactos contacto = null;
        lista = new ArrayList<Contactos>();

        // Cursor de Base de Datos
        Cursor cursor = db.rawQuery(Transacciones.SelectTableContacto,null);

        // recorremos el cursor
        while(cursor.moveToNext())
        {
            contacto = new Contactos();
            contacto.setId_contacto(cursor.getInt(0));
            contacto.setPais(cursor.getString(1));
            contacto.setNombre(cursor.getString(2));
            contacto.setTelefono(cursor.getInt(3));
            contacto.setNota(cursor.getString(4));
            contacto.setFoto(cursor.getString(5));

            lista.add(contacto);
        }

        cursor.close();

        fillList();
    }


    private void fillList()
    {
        ArregloContactos = new ArrayList<String>();

        for(int i=0; i < lista.size(); i++)
        {
            ArregloContactos.add(lista.get(i).getId_contacto() + " - "
                    +lista.get(i).getNombre() + " - "
                    +lista.get(i).getTelefono());
        }
    }


}