package com.example.daniel.clinichistory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CitasMedicas extends AppCompatActivity {
    TextView vista;
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_medicas);
        vista = (TextView)findViewById(R.id.txt_cm_Vista);
        regresar = (Button)findViewById(R.id.btnRegresarCm);
        LeerCitas();

    }

    public void LeerCitas(){
        try {
            InputStreamReader isr = new InputStreamReader(this.getResources().openRawResource(R.raw.citas));
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
    /*public void LeerCitas(View view){
        String linea = "";
        try
        {
            InputStream f = getResources().openRawResource(R.raw.citas);

            BufferedReader br = new BufferedReader(new InputStreamReader(f));

            linea = br.readLine();
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
            Toast.makeText(this,"No se puede leer el fichero",Toast.LENGTH_SHORT).show();
        }
    }*/

    public void RegresarCM(View view){
        Intent interfaz = new Intent(this,Principal.class);
        startActivity(interfaz);


    }

}
