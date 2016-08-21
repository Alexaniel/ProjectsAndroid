package com.example.daniel.practicechoices;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {
    EditText cedula,nombre,apellido,correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        cedula = (EditText)findViewById(R.id.etxtCedula);
        nombre = (EditText)findViewById(R.id.etxtNombre);
        apellido = (EditText)findViewById(R.id.etxtApellido);
        correo = (EditText)findViewById(R.id.etxtCorreo);
    }

    public void Registrarse(View view){
        BDatos base = new BDatos(this);
        SQLiteDatabase db = base.getWritableDatabase();
        if (db != null){
            ContentValues valores = new ContentValues();
            valores.put("cedula",cedula.getText().toString());
            valores.put("nombre",nombre.getText().toString());
            valores.put("apellido",apellido.getText().toString());
            valores.put("correo",correo.getText().toString());
            if (cedula.getText().toString().length()==0)
                cedula.setError("Ingrese la cedula");
                else if(nombre.getText().toString().length()==0)
                    nombre.setError("Nombre Obligatorio");
                    else if(apellido.getText().toString().length()==0)
                        apellido.setError("Apellido Obligatorio");
                        else if(correo.getText().toString().length()==0)
                            correo.setError("Correo Obligatorio");
                            else{
                                db.insert("usuarios",null,valores);
                                db.close();
                                limpiar();
                                Toast.makeText(this,"Se ha registrado correctamente",Toast.LENGTH_SHORT).show();
                            }
        }else{
            Toast.makeText(this,"No existe la tabla",Toast.LENGTH_SHORT).show();
        }
    }

    public void Listar(View view){
        Intent usuarios = new Intent(this,Formulario2.class);
        startActivity(usuarios);
    }

    private void limpiar(){
        cedula.setText(" ");
        nombre.setText(" ");
        apellido.setText(" ");
        correo.setText(" ");
    }
    public void Regresar(View view){
        Intent principal = new Intent(this,Principal.class);
        startActivity(principal);
    }


}
