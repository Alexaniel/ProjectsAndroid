package com.example.daniel.practicechoices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {
    Button suma,resta,multiplicacion,division,regresar;
    EditText num1,num2;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        total = (TextView)findViewById(R.id.txtResultado);

        num1 = (EditText)findViewById(R.id.etxtnum1);
        num2 = (EditText)findViewById(R.id.etxtnum2);

        suma = (Button)findViewById(R.id.btnSuma);
        resta = (Button)findViewById(R.id.btnResta);
        multiplicacion = (Button)findViewById(R.id.btnMult);
        division = (Button)findViewById(R.id.btnDiv);
        regresar = (Button)findViewById(R.id.btnRegresar);
    }

    public void Suma(View view){
        int a =Integer.parseInt(num1.getText().toString());
        int b =Integer.parseInt(num2.getText().toString());
        total.setText(String.valueOf(a+b));
    }
    public void Resta(View view){
        int a =Integer.parseInt(num1.getText().toString());
        int b =Integer.parseInt(num2.getText().toString());
        total.setText(String.valueOf(a-b));
    }
    public void Multiplicacion(View view){
        int a =Integer.parseInt(num1.getText().toString());
        int b =Integer.parseInt(num2.getText().toString());
        total.setText(String.valueOf(a*b));
    }
    public void Division(View view){
        int a =Integer.parseInt(num1.getText().toString());
        int b =Integer.parseInt(num2.getText().toString());
        total.setText(String.valueOf(a/b));
    }
    public void Regresar(View view){
        Intent principal = new Intent(this,Principal.class);
        startActivity(principal);
    }
}
