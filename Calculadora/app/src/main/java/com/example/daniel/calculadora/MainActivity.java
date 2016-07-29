package com.example.daniel.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void suma(View view){
        EditText t1 = (EditText) findViewById(R.id.editText);
        EditText t2 = (EditText) findViewById(R.id.editText2);
        TextView entrada = (TextView) findViewById(R.id.resultado);
        int a =Integer.parseInt(t1.getText().toString());
        int b =Integer.parseInt(t2.getText().toString());
        entrada.setText(String.valueOf(a+b));
    }
    public void resta(View view){
        EditText t1 = (EditText) findViewById(R.id.editText);
        EditText t2 = (EditText) findViewById(R.id.editText2);
        TextView entrada = (TextView) findViewById(R.id.resultado);
        int a =Integer.parseInt(t1.getText().toString());
        int b =Integer.parseInt(t2.getText().toString());
        entrada.setText(String.valueOf(a-b));
    }
    public void multiplicar(View view){
        EditText t1 = (EditText) findViewById(R.id.editText);
        EditText t2 = (EditText) findViewById(R.id.editText2);
        TextView entrada = (TextView) findViewById(R.id.resultado);
        int a =Integer.parseInt(t1.getText().toString());
        int b =Integer.parseInt(t2.getText().toString());
        entrada.setText(String.valueOf(a*b));
    }
    public void dividir(View view){
        EditText t1 = (EditText) findViewById(R.id.editText);
        EditText t2 = (EditText) findViewById(R.id.editText2);
        TextView entrada = (TextView) findViewById(R.id.resultado);
        int a =Integer.parseInt(t1.getText().toString());
        int b =Integer.parseInt(t2.getText().toString());
        entrada.setText(String.valueOf(a+b));
    }
}
