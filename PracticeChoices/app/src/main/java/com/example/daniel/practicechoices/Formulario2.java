package com.example.daniel.practicechoices;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Formulario2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario2);
        ListarUsuarios();
    }

    public void ListarUsuarios(View view){
        BDatos base = new BDatos(this);
        SQLiteDatabase db = base.getWritableDatabase();
        if(db != null){
            Cursor c= db.rawQuery("select * from Usuarios",null);
            int cantidad = c.getCount();
            int i=0;
            String[] datos = new String[cantidad];
            if(c.moveToFirst()){
                do{
                    String linea = c.getInt(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getString(3)+" "+c.getString(4);
                    datos[i] = linea;
                    i++;
                }while (c.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
            ListView lista = (ListView)findViewById(R.id.lista);
            lista.setAdapter(adapter);
        }
}
