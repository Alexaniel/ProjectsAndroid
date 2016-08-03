package com.example.daniel.formulario;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //llamar directamente a la funcion cuando se llama a la nueva actividad
        Listar();
    }

    public void Listar(){
        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this,"DBUsuarios",null,1);
        SQLiteDatabase db = usdbh.getReadableDatabase();
        if(db != null){
            Cursor c= db.rawQuery("select * from Usuarios",null);
            //variable para contar el numero de registros
            int cantidad = c.getCount();
            //arreglo de registros
            int i=0;
            String[] datos = new String[cantidad];

            // se ubica en el primer registro
            if(c.moveToFirst()){
                //hacer hasta que hay registros si no hay mas registros sale
                do{
                    //muestra el campos de la tabla el id,nombre,apellido y correo
                    String linea = c.getInt(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getString(3)+" "+c.getString(4);

                    datos[i] = linea;
                    i++;
                }while (c.moveToNext());
            }

            //crear un adaptador para la lista
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
            //asignamos al list view la lista para pasarle el adaptador
            ListView lista = (ListView)findViewById(R.id.lista);
            lista.setAdapter(adapter);

        }
    }
}
