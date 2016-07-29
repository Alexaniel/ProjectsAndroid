package com.example.daniel.archivo;
import android.util.Log;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.io.*;
/*import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;*/


public class MainActivity extends AppCompatActivity {

    EditText entrada,salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText)findViewById(R.id.txtIngresar);
        salida = (EditText)findViewById(R.id.txtSalida);
    }

    public void escribir(View view){
        OutputStreamWriter escritor=null;
        try {
            escritor = new OutputStreamWriter(openFileOutput("archivo.txt", Context.MODE_PRIVATE));
            escritor.write(entrada.getText().toString());
            //escritor.close();

        }catch (Exception ex){
            Log.e("Alex","No pudimos abrir el archivo");
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
            Log.e("Alex","No se pudo leer el archivo");
        }finally {
            try {
                if(flujo!=null)
                    flujo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
