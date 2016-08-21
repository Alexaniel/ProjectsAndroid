package com.example.daniel.practicas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MemInterna extends AppCompatActivity {

    EditText entrada,salida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_interna);
        entrada = (EditText)findViewById(R.id.txtIngresar);
        salida = (EditText)findViewById(R.id.txtSalida);
    }

    public void escribir(View view){
        OutputStreamWriter escritor=null;
        try {
            escritor = new OutputStreamWriter(openFileOutput("archivo.txt", Context.MODE_PRIVATE));
            escritor.write(entrada.getText().toString());
        }catch (Exception ex){
            Toast.makeText(this,"No se puede escribir en el archivo",Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if(escritor!=null)
                    escritor.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void leer(View view){
        InputStreamReader flujo=null;
        BufferedReader lector=null;
        try {
            flujo = new InputStreamReader(openFileInput("archivo.txt"));
            lector = new BufferedReader(flujo);
            String cadena=" ";
            cadena=lector.readLine();
            salida.setText(cadena);
            lector.close();
        }catch(Exception ex){
            Toast.makeText(this,"No se puede leer el archivo",Toast.LENGTH_SHORT).show();
        }finally {
            try {
                if(flujo!=null)
                    flujo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void Regresar(View view){
        Intent principal = new Intent(this,Principal.class);
        startActivity(principal);
    }
}
