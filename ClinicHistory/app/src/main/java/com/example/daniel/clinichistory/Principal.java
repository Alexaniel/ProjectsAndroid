package com.example.daniel.clinichistory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
    public  void Registrar(View view){
        Intent interfaz= new Intent(this,Registrar.class);
        startActivity(interfaz);
    }

    public void Modificar(View view){
        Intent interfaz= new Intent(this,Modificar.class);
        startActivity(interfaz);
    }

    public void Listar(View view){
        Intent interfaz= new Intent(this,Listar.class);
        startActivity(interfaz);
    }

    public void CitasMedicas(View view){
        Intent interfaz =  new Intent(this,CitasMedicas.class);
        startActivity(interfaz);
    }
}
