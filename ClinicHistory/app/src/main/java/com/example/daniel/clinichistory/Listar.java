package com.example.daniel.clinichistory;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Listar extends AppCompatActivity {
    GridView tabla;
    //ListView tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        tabla = (GridView)findViewById(R.id.gridView);
        //coleccion de elementos para enviarlos al gridView
        List<String> lista = new ArrayList<String>();
        //se agrega el adaptador
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,lista);
        //obtener el data de la base de datos
        BDatos base = new BDatos(this);
        SQLiteDatabase db = base.getWritableDatabase();
        Cursor datos = db.rawQuery("Select * from paciente",null);
        if(datos!=null){
            lista.add(" ");
            lista.add("LISTADO DE PACIENTES");
            lista.add(" ");
            while(datos.moveToNext()){
                lista.add("Paciente: "+datos.getString(1)+" "+datos.getString(2));
                lista.add("Cedula: "+datos.getString(0));
                lista.add("Telefono: "+datos.getString(3));
                lista.add("Direccion: "+datos.getString(4));
                lista.add(" ");
                tabla.setAdapter(adapter);
            }
        }
        //tabla = (ListView)findViewById(R.id.listView);
        //BDatos base = new BDatos(this);
        //SQLiteDatabase db = base.getWritableDatabase();
        /*Cursor c = db.rawQuery("select * from paciente",null);
        int cantidad = c.getCount();
        int i=0;
        String[] datos = new String[cantidad];

        if(c.moveToFirst()){
            do{
                String linea = c.getString(0)+" "+c.getString(1)+" "+c.getString(2)+""+c.getString(3)+" "+c.getString(4);
                datos[i] = linea;
                i++;
            }while(c.moveToNext());
        }

        //se agrega el adaptador
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,datos);
        ListView lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adapter);*/


    }
}
