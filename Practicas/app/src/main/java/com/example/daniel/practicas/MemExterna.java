package com.example.daniel.practicas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MemExterna extends AppCompatActivity {
    TextView vista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mem_externa);
        vista=(TextView)findViewById(R.id.txtView);
        LeerArchivo();
    }
    public void LeerArchivo(){
        try {
            InputStreamReader isr = new InputStreamReader(this.getResources().openRawResource(R.raw.texto));
            BufferedReader br = new BufferedReader(isr);

            String linea;

            StringBuilder texto = new StringBuilder();

            while((linea = br.readLine()) != null)
            {
                texto.append(linea);
                texto.append("\n");
            }
            br.close();
            isr.close();
            vista.setText(texto.toString());

        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void Regresar(View view){
        Intent principal = new Intent(this,Principal.class);
        startActivity(principal);
    }
}
