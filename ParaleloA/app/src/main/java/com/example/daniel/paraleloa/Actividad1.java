package com.example.daniel.paraleloa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
    }

    public void imprimir(View view){
        //obtener el dato que se escribe en el text
        EditText entrada = (EditText) findViewById(R.id.entrada);
        EditText salida = (EditText) findViewById(R.id.salida);
        String cadena = entrada.getText().toString();
        salida.setText("Hola "+ cadena);
    }

    public void
}
