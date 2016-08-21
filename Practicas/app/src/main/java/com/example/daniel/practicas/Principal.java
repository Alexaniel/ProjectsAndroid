package com.example.daniel.practicas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
    public void Calculadora(View view){
        Intent calculadora = new Intent(this,Calculadora.class);
        startActivity(calculadora);
    }

    public void Sensores(View view){
        Intent sensores = new Intent(this,Sensores.class);
        startActivity(sensores);
    }

    public void Formulario(View view){
        Intent form = new Intent(this,Formulario.class);
        startActivity(form);
    }

    public void MemInterna(View view){
        Intent memInterna = new Intent(this,MemInterna.class);
        startActivity(memInterna);
    }

    public void MemExterna(View view){
        Intent memExterna = new Intent(this,MemExterna.class);
        startActivity(memExterna);
    }

    public void Notificaciones(View view){
        Intent notificacion = new Intent(this,Notificaciones.class);
        startActivity(notificacion);
    }
}
