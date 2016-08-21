package com.example.daniel.practicechoices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
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
    public void LeerArchivo(View view){
        try
        {
            InputStream f = getResources().openRawResource(R.raw.texto);
            BufferedReader br = new BufferedReader(new InputStreamReader(f));
            String linea = br.readLine();
            StringTokenizer dato = new StringTokenizer(linea,";-");

            while (dato.hasMoreTokens()){
                for(int i=1;i<dato.countTokens();i++){
                    vista.append(dato.nextToken()+"\n");
                }
            }
            f.close();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"No se puede leer archivo",Toast.LENGTH_SHORT).show();
        }
    }
    public void Regresar(View view){
        Intent principal = new Intent(this,Principal.class);
        startActivity(principal);
    }
}
