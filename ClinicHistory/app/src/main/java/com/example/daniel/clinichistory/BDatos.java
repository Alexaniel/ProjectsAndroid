package com.example.daniel.clinichistory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDatos extends SQLiteOpenHelper{

    public BDatos(Context context) {
        super(context, "clinica.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table paciente (cedula TEXT PRIMARY KEY , nombre TEXT, apellido TEXT, telefono TEXT, direccion TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists paciente");
        sqLiteDatabase.execSQL("create table paciente (cedula TEXT PRIMARY KEY , nombre TEXT, apellido TEXT, telefono TEXT, direccion TEXT)");
    }
}
