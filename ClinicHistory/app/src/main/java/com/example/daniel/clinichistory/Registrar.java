package com.example.daniel.clinichistory;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity {
    EditText cedula,nombre,apellido,telefono,direccion;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        cedula = (EditText)findViewById(R.id.etxt_i_Cedula);
        nombre = (EditText)findViewById(R.id.etxt_i_Nombre);
        apellido = (EditText)findViewById(R.id.etxt_i_Apellido);
        telefono = (EditText)findViewById(R.id.etxt_i_Telefono);
        direccion = (EditText)findViewById(R.id.etxt_i_Direccion);
        regresar = (Button)findViewById(R.id.btnVolverR);
    }

    public void RegistrarPaciente(View view){
        //objeto para acceder a la base de datos
        BDatos base = new BDatos(this);
        SQLiteDatabase db = base.getWritableDatabase();
        //fijar elementos para insertarlos en la base de datos
        ContentValues valores = new ContentValues();

        valores.put("cedula",cedula.getText().toString());
        valores.put("nombre",nombre.getText().toString());
        valores.put("apellido",apellido.getText().toString());
        valores.put("telefono",telefono.getText().toString());
        valores.put("direccion",direccion.getText().toString());
        //insertamos valores
        if (cedula.getText().toString().length()==0)
            cedula.setError("Ingrese la cedula");
            else if(nombre.getText().toString().length()==0)
                nombre.setError("Nombre Obligatorio");
                else if(apellido.getText().toString().length()==0)
                    apellido.setError("Apellido Obligatorio");
                    else if(telefono.getText().toString().length()==0)
                        telefono.setError("Telefono Obligatorio");
                    else if (direccion.getText().toString().length()==0)
                        direccion.setError("Direccion Obligatoria");
                    else{
                        db.insert("paciente",null,valores);
                        db.close();
                        limpiar();
                        Toast.makeText(this,"Se ha registrado correctamente su paciente",Toast.LENGTH_SHORT).show();
                    }
        //Log.i("Paciente","Se ha registrado un nuevo paciente");
    }

    public void RegresarR(View view){
        Intent interfaz= new Intent(this,Principal.class);
        startActivity(interfaz);
    }

    private void limpiar(){
        cedula.setText(" ");
        nombre.setText(" ");
        apellido.setText(" ");
        telefono.setText(" ");
        direccion.setText(" ");
    }
}
