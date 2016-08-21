package com.example.daniel.practicas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel on 21/8/2016.
 */

public class BDatos extends SQLiteOpenHelper {

    public BDatos(Context context) {
        super(context, "empresa.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table usuarios (cedula TEXT PRIMARY KEY , nombre TEXT, apellido TEXT, correo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuarios");
        sqLiteDatabase.execSQL("create table usuarios (cedula TEXT PRIMARY KEY , nombre TEXT, apellido TEXT, correo TEXT)");
    }
}