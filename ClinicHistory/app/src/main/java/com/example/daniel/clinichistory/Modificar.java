package com.example.daniel.clinichistory;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modificar extends AppCompatActivity {
    EditText cedula,nombre,apellido,telefono,direccion;
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        cedula = (EditText)findViewById(R.id.etxt_m_Cedula);
        nombre = (EditText)findViewById(R.id.etxt_m_Nombre);
        apellido = (EditText)findViewById(R.id.etxt_m_Apellido);
        telefono = (EditText)findViewById(R.id.etxt_m_Telefono);
        direccion = (EditText)findViewById(R.id.etxt_m_Direccion);

        regresar = (Button)findViewById(R.id.btnRegresarM);
    }
    public void ModificarPaciente(View view){
        if(cedula.getText().toString().length()==0){
            cedula.setError("Ingrese la cedula");
        }else {
            BDatos base = new BDatos(this);
            SQLiteDatabase db = base.getWritableDatabase();

            ContentValues valores = new ContentValues();

            valores.put("nombre",nombre.getText().toString());
            valores.put("apellido",apellido.getText().toString());
            valores.put("direccion",direccion.getText().toString());
            valores.put("telefono",telefono.getText().toString());

            int c = db.update("paciente",valores,"cedula='"+cedula.getText().toString()+"'",null);
            if(c==1)
                Toast.makeText(this,"Se guardo cambios del paciente",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"No se pudo modificar el paciente",Toast.LENGTH_SHORT).show();
            db.close();
            limpiar();
        }
    }
    public void BuscarPaciente(View view){
        if(cedula.getText().toString().length()==0){
            cedula.setError("Ingrese la cedula");
        }else{
            BDatos base=new BDatos(this);
            SQLiteDatabase db= base.getWritableDatabase();

            Cursor fila= db.rawQuery("select nombre, apellido, direccion,telefono from paciente where cedula= '"+cedula.getText().toString()+"' ",null);
            if(fila==null){
                if(fila.moveToFirst()){
                    nombre.setText(fila.getString(1));
                    apellido.setText(fila.getString(2));
                    direccion.setText(fila.getString(3));
                    telefono.setText(fila.getString(4));
                }else{
                    Toast.makeText(this,"No se encuentra registrado el paciente",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void EliminarPaciente(View view){
        if(cedula.getText().toString().length()==0){
            cedula.setError("Ingrese la cedula");
        }else {
            BDatos base = new BDatos(this);
            SQLiteDatabase db = base.getWritableDatabase();
            int sql = db.delete("paciente","cedula='" + cedula.getText().toString() + "'", null);
            if (sql==1)
                Toast.makeText(this,"Paciente Eliminado",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,"No se elimino el paciente",Toast.LENGTH_SHORT).show();
            db.close();
            limpiar();
        }
    }

    private void limpiar(){
        cedula.setText(" ");
        nombre.setText(" ");
        apellido.setText(" ");
        telefono.setText(" ");
        direccion.setText(" ");
    }

    public void Regresar(View view){
        Intent interfaz = new Intent(this,Principal.class);
        startActivity(interfaz);
    }
}
