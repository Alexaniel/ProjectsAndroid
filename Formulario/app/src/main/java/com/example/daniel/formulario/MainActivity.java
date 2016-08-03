package com.example.daniel.formulario;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etnombre, etapellido, etcorreo, etcedula,etaviso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etcedula = (EditText) findViewById(R.id.etCedula);
        etnombre = (EditText) findViewById(R.id.etNombre);
        etapellido = (EditText) findViewById(R.id.etApellido);
        etcorreo = (EditText) findViewById(R.id.etCorreo);
        etaviso = (EditText) findViewById(R.id.etAviso);
        etaviso.setError("Todos los campos son necesarios");
    }

    public void Guardar(View view){
        int cedula=Integer.parseInt(etcedula.getText().toString());
        String nombre=etnombre.getText().toString();
        String apellido=etapellido.getText().toString();
        String correo=etcorreo.getText().toString();


        UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this,"DBUsuarios",null,1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        if(db != null){
            ContentValues registronuevo = new ContentValues();
            registronuevo.put("cedula",cedula);
            registronuevo.put("nombre",nombre);
            registronuevo.put("apellido",apellido);
            registronuevo.put("correo",correo);
            long i = db.insert("Usuarios",null,registronuevo);
            if(i>0) {
                //Agrega mensajes segun la accion
                Toast.makeText(this, "Nuevo Registros Insertados", Toast.LENGTH_SHORT).show();
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        if (id == R.id.action_listar){
            startActivity(new Intent(this,MainActivity2.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
